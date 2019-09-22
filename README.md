# TURNtoURN

## Contents

* **ATL:** .atl files used to perform the transformation
	* *Turn2URN.atl:* contains all the matched rules & helper methods used in the code.
	* *Create.atl:* contains called rules used to either instantiate or initialize Urn elements.
	* *Connect.atl:* contains called rules used to connect the URN elements, primarily using the Turn pathbodies for information.
  
* **Test** 
	* *ExpectedOutputs:* contains the expected output .jucm files for all test cases.
	* *Input:* TURN model files saved in .xml format. This files in this directory are used by the launch configurations in LaunchConfigurations.
	* *LaunchConfigurations:* contains the launch configurations for all test cases for the system. These output their files to the /Test/Output directory, creating it if it doesn't exist.
  
* **Metamodels** 
	* *Turn.ecore:* the metamodel for TURN. 

## Matched Rule Ordering
* Last 3 matched rules should be URNspec2URNspec, then InBinding2InBinding + OutBinding2OutBinding
* Other orderings do not matter and can be placed anywhere in the file, including in between the aforementioned rules.

## TODO
* Remove TODO statements
* Make getter helpers more explicitly return either a TURN or URN object
* Refactor for increased readability
	* Rearrange methods so that their order feels more natural.
	* Make variable name orderings in method arguments consistent
	* Rename methods and variables so that their names better describe their behavior and contents respectively
	* Rename variable names in 'using' blocks with a better convention
	* Write down the return type for each called rule
* Refactor for increased consistency
	* Make sure all select(n.name='') are consistent in (Turn2Urn remains)
	* Files
		* Update names of .turn input files in TURNTestInput to match with new xml file names
		* Update names of files and test cases to be consistent with names of turn/urn items (e.g., Endpoint to EndPoint)
		* Describe in this README how to use the launch configurations that have been added to the project
		* Describe how to verify correctness of functionalities when working on this system
	* TURN
		* Check if it is acceptable to rename some TURN variables for more consistency in naming
			* EndpointWithConnect vs EndPoint
			* LongName.longname
			* Softgoal
		* Why is failLabel an object with failure as a property rather than just a string failLabel?
		* Why can an OrFork body be oclUndefined? Is there any way to make it so that it’s empty if there’s nothing in it rather than undefined?

* New TODO (will be categorized later):
	* Determine which attributes are not being tested (e.g., author in tStrategies)
	* Find a way to remove the maps used in the transform
	* Write comments describing what rules do
	* Write a script / create a plugin which automatically parses code to create header-like descriptions of file contents at the start of the file
		* Something with subsections using headings which makes a list of all the rules in each subsection

## Style
* Variable naming:
	* Prefixes:
		* v = primitive data type
		* s = source MM data type
		* t = target MM data type
	* Name:
		* Depending on the context, write either a descriptive name for the element or otherwise use the full name of the model item 
			* (e.g., sEndPoint says that an element is a Turn!EndPoint)
* Conditionals:
	* All if and else loops, including single line ones, should have braces
* Variable declaration - spacing, use of parentheses - TODO: make this match the ATL user guide