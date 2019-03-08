# TURNtoURN

## Contents

###Transformation from TURN to URN using ATL
  
**ATL -** Phase 1 of transformation. Turn2Urn.atl is the primary transformation file and **uses** ConnectNodes.atl using Module Superimposition  
  
**Input -** TURN model saved in .xml format (sample file provided)  
  
**Output -** .jucm output generated by transformation  
  
**Metamodels -** Turn.ecore    
  
**Expected Outputs -** expected output .jucm files for all test cases  
  
**Turn2UrnPhase2.java -** Phase 2 of transformation 

## ACTIVE TASK
I am currently troubleshooting the code to look for issues that cause either incorrect outputs or runtime errors.

### Progress
* Belief.tucm = belief.tucm ?
	* Mostly. Two lines are different. These warrant discussion with Ruchika.

## ISSUES
1. The test StartPointTestNoName causes an error in UCMmap2UCMmap. This is because the way UCMmap2UCMmap is currently written means a StartPoint must exist.
2. The test EndPointTestNoName causes an error in UCMmap2UCMmap. This is because the way UCMmap2UCMmap is currently written means all PathEnds must have a RegularEnd in them. The specific line in endpoint.xml reads:
	```
	<pathBody xsi:type="turn:PathBodyNodes">
		<pathEnd xsi:type="turn:EndpointWithConnect"/>
	</pathBody>
	```
After noting the above, I looked at startpoint.xml as a point of reference. In that, no StartPoint is created at all. This actually causes the first bug, listed above. That brings three cases to mind:
* EndPointTestNoName should have no EndPointWithConnect to match the behavior shown in StartPointTestNoName
* StartPointTestNoName should have a StartPoint with a RegularEnd with some default name, and so EndPointTestNoName should have the same.
* The EndPointWithConnect without a RegularEnd should be handled somewhere in the code, and StartPointNoName should create a StartPoint with no RegularEnd which is also handled somewhere else in the code.
3. In the rules InBinding2InBinding and OutBinding2OutBinding, there is an attempt to retrieve an item from the stubMap which is not in the stubMap. This causes an issue with executing the tests for stub.xml, component.xml, and responsibility.xml; I have not yet pinpointed the source of this issue beyond what lines it occurs in.	

## TODO
* Verify functionality (first priority)
	* Look at all uses of -> including and -> union to see if they are behaving correctly
		* Look to see if any other places should have -> including or -> union called instead of simple assignments
		* I may have been wrong with regards to this behavior; I need to revisit this later.
	* Make sure all typings are correct; I'm worried that sometimes we pass in a sequence to a method that takes in a single value as an argument (e.g., collectRegularEnds)
	* Go over all matched rules to make sure assignments are from Urn object to Urn object (i.e., that resolveTemps are used where appropriate)
	* Make sure that no issues are occurring because tUCMmap is only updated in UCMmap2UCMmap; this seems highly likely to cause issues with tUCMmap.getNode() calls 
	* Verify ordering of operations that add nodes to tUCMmap in create called rules (e.g., createTimer) is correct
* Refactor for better coding practice (second priority)
	* Verify the lifetime of variables to make sure they aren't sitting around eternally
	* Determine why we pass along tUCMmap rather than storing it in a global variable like OrForkMap, AndForkMap; pick one convention to stick to
	* Look to see if there is a way to remove any or all map global objects
* Refactor for increased readability
	* Rearrange methods so that their order feels more natural.
	* Change names of variables that are single letters (in particular, haven't handled this in the case of parameters for called rules)
	* Make variable name orderings in method arguments consistent
	* Rename methods and variables so that their names better describe their behavior and contents respectively
	* Rename variable names in 'using' blocks with a better convention
	* Write down the return type for each called rule
	* Rename any Urn object variable names to start with a 't' for consistency and clarity and Turn object variable names with an 's'
	* Make all "using" variables start with v, all argument variables with a, source object with s, target object with t
* Refactor for increased consistency
	* All if and else loops, including single line ones, should have braces
	* Decide on a naming convention for source and target model elements. Either stick to s and t or have the names be descriptive.
	* Need consistency with whether empty from / to items have () or not
	* Decide if all conditionals should have an else loop that explicitly states the else case should not be entered in valid method calls
		* Determine if error messages can be sent out by ATL in these cases
	* Make all caps variable names into camel case (all caps was for refactoring purposes to make variable names easier to find)
	* Make sure all select(n.name='') are consistent in (Turn2Urn remains)
	* Files
		* Update names of .turn input files in TURNTestInput to match with new xml file names
		* Update names of files and test cases to be consistent with names of turn/urn items (e.g., Endpoint to EndPoint)
		* Create a "test" folder to contain Input, Output, LaunchConfiguration, previousOutput (or find some other way to structures the directory better than its current more arbitrary state)
		* Describe in this README how to use the launch configurations that have been added to the project
	* TURN
		* Check if it is acceptable to rename some TURN variables for more consistency in naming
			* EndpointWithConnect vs EndPoint
			* LongName.longname
		* Why is failLabel an object with failure as a property rather than just a string failLabel?
* New TODO (will be categorized later):
	* Determine which attributes are not being tested (e.g., author in tStrategies)
	* Figure out if it is possible to make an implementation that uses matched rules for OrFork, AndFork, etc.
	* Find a way to remove the maps
	* Ensure nextGlobalId is correct
	* Write comments describing what rules do
	* Verify variable declaration typings are correct
	* Current issues in output produced by new code:
		* AndFork:
			* OrJoins missing (lines 33, 409, 477 of original file); corresponding NodeConnection missing as well
			* extra pred in FailurePoint (line 465 of new file)
			* extra pred in RespRef (line 399 of new file)
			* missing pred in Timer (line 380 of new file)
			* missing succ in EmptyPoint (lines 321, 350, 376 of new file)
			* missing AndJoin (line 111 of original file)
			* missing NodeConnections (lines 330, 360 of old file)