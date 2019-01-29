# TURNtoURN

## Transformation from TURN to URN using ATL
  
**ATL -** Phase 1 of transformation. Turn2Urn.atl is the primary transformation file and **uses** ConnectNodes.atl using Module Superimposition  
  
**Input -** TURN model saved in .xml format (sample file provided)  
  
**Output -** .jucm output generated by transformation  
  
**Metamodels -** Turn.ecore    
  
**Expected Outputs -** expected output .jucm files for all test cases  
  
**Turn2UrnPhase2.java -** Phase 2 of transformation 

## TODO
* Replace "conns" for "connections" where relevant (if conns does indeed stand for connections)
	* Helpers:
		* orForkNodeConnCounter
		* andForkNodeConnCounter
	* Rules:
		* createNodeConns
		* createOrForkNodeConns
		* createAndForkNodeConns
* Decide on a naming convention for source and target model elements. Either stick to s and t or have the names be descriptive.
* Start returning code from ConnectNodesTemporarilyRemovedCode to ConnectNodes.atl. Refactor it and improve its efficiency as you go.
* Continue returning code from Turn2UrnTemporarilyRemovedCode.txt to Turn2URN.atl. Refactor it and improve its efficiency as you go.
	* Remaining rules to add are shown in Turn2Urn.atl
	* To revisit:
		* From/to blocks of all rules
		* All helper rules created
		* createOrForkNodeConns(ref: Turn!RegularOrFork,  tUCMmap: Urn!UCMmap)
		* URNspec2URNspec
		* Belief2Belief
		* FailurePoint2FailurePoint
		* StartPoint2StartPoint
		* AndJoin2AndJoin
		* OrJoin2OrJoin
* Potential patterns to generalize into methods:
	* x -> collect(y|y.someProperty) -> flatten() -> collect(z|thisModule.resolveTemp(z, 'someString'))
	* is it possible to use the called rules created as methods directly in the "to" block? That would remove the need for a lot of the do blocks.
	* determine if the ordering of the conditional statements in InBinding2InBinding and OutBinding2OutBinding matters; if not then they can be modularized
* Change names of variables that are single letters (in particular, haven't handled this in the case of parameters for called rules)
* Rearrange methods so that their order feels more natural.
* Note that this is not like an OOP language where initNextItem instantiates the object before it can be assigned a name; the object is initialized in the "for" block; the choice of calling id first is merely for familiarity