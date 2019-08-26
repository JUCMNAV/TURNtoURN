
package org.xtext.project.turn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.xtext.project.turn.turn.TurnPackage;

import ucm.map.OrJoin;
import ucm.map.PathNode;
import ucm.map.RespRef;
import ucm.map.Timer;
import ucm.map.UCMmap;
import ucm.map.ComponentRef;
import ucm.map.Connect;
import ucm.map.EmptyPoint;
import ucm.map.MapFactory;
import ucm.map.MapPackage;
import ucm.map.NodeConnection;
import ucm.map.impl.OrJoinImpl;
import ucm.map.impl.PathNodeImpl;
import urn.URNspec;
import urn.UrnFactory;
import urn.UrnPackage;
import urncore.Component;
import urncore.IURNDiagram;
import urncore.IURNNode;
import urncore.Metadata;
import urncore.URNdefinition;
import urncore.UrncorePackage;

public class Turn2UrnPhase2 {
	private static Integer id;

	public static void main(String argv[]) {
		try {
			String input = "tcme.jucm";
			String output = "tcmee-final-auto.jucm";

			File inFile = new File(input);
			File outFile = new File(output);

			// load the URN resource
			UrnPackage.eINSTANCE.eClass();
			Resource resource = new XMIResourceImpl();
			resource.load(new FileInputStream(inFile), new HashMap<Object, Object>());

			// get the root node here
			URNspec spec = (URNspec) resource.getContents().get(0);
			URNdefinition urnDef = spec.getUrndef();
			EList<IURNDiagram> specDiagrams = urnDef.getSpecDiagrams();
			// get map factory instance to create new elements
			MapFactory mapFactory = MapPackage.eINSTANCE.getMapFactory();
			// getting the max. id of an element (map here)
			id = Integer.valueOf(specDiagrams.get(specDiagrams.size() - 1)
					.eGet(MapPackage.Literals.UC_MMAP.getEStructuralFeature("id")).toString());

			for (IURNDiagram map : specDiagrams) {
				Timer timerConnect = null;
				Connect connect = null;
				Boolean asynch = false;
				EmptyPoint emptyPt = null;
				Boolean connectedOrFork = false;
				// create an OR JOIN and Node Connection
				List<IURNNode> nodes = map.getNodes();
				for (ListIterator<IURNNode> iter = nodes.listIterator(); iter.hasNext();) {
					IURNNode node = iter.next();

					if ((node.eClass().getName().equals("Connect"))) {
						connect = (Connect) node;

					}
//					else if((node.eClass().getName().equals("EndPoint") || node.eClass().getName().equals("RespRef") || node.eClass().getName().equals("FailurePoint")) && node.getPred().size() > 1){
//						//create an OR JOIN
//						id+=1;
//						PathNode join=null;
//						join = mapFactory.createOrJoin();
//						join.setName("OrJoin"+id);
//						join.setId(id.toString());
//						join.eSet(MapPackage.Literals.OR_JOIN.getEStructuralFeature("pred"), node.getPred());
//						join.setContRef(node.getContRef());
//						//create Node Connection for OR JOIN
//						NodeConnection nc = mapFactory.createNodeConnection();
//						List<NodeConnection> list = new ArrayList<NodeConnection>();
//						list.add(nc);
//						join.eSet(MapPackage.Literals.OR_JOIN.getEStructuralFeature("succ"), list);
//						node.eSet(MapPackage.Literals.END_POINT.getEStructuralFeature("pred"), list);
//						iter.add(join);
//						map.getConnections().add(nc);
//					}
//
//					else if (node.eClass().getName().equals("EmptyPoint")) {
//
//						emptyPt = (EmptyPoint) node;
//						// asynchronous connects to timer
//						// check FOR SAME MAP HERE
//						if (emptyPt.getName().contains("ConnectTimer#")) {
//							String connectedtimerName = "";
//							if (emptyPt.getName().contains("AsynchConnectTimer#")) {
//								connectedtimerName = emptyPt.getName().substring(19);
//								asynch = true;
//							} else if (emptyPt.getName().contains("SynchConnectTimer#")) {
//								connectedtimerName = emptyPt.getName().substring(18);
//							}
//							
//							timerConnect = getTimer(nodes, connectedTimerName);
//						}
//						if (timerConnect != null) {
//							if (asynch) {
//								List<NodeConnection> emptyPtSucc = new ArrayList<NodeConnection>();
//								NodeConnection timerPredNC = (NodeConnection) timerConnect.getPred().get(0);
//								NodeConnection timerSuccNC = (NodeConnection) timerConnect.getSucc().get(0);
//								NodeConnection emptyPtNC = (NodeConnection) emptyPt.getPred().get(0);
//								IURNNode timerPred = timerPredNC.getSource();
//								int timerPredSuccIndex = timerPred.getSucc().indexOf(timerPredNC);
//								List<NodeConnection> timerPredSuccList = new ArrayList<NodeConnection>();
//								timerPredSuccList.add((NodeConnection) timerPred.getSucc().get(timerPredSuccIndex));
//								IURNNode emptyPtPred = emptyPtNC.getSource();
//								IURNNode timerSucc = timerSuccNC.getTarget();
//								emptyPt.eSet(MapPackage.Literals.PATH_NODE.getEStructuralFeature("pred"),
//										timerPredSuccList);
//								for (Object obj : emptyPtPred.getSucc()) {
//									NodeConnection nc = (NodeConnection) obj;
//									if (nc.getCondition() != null && emptyPtNC.getCondition() != null) {
//										if (nc.getCondition().getExpression()
//												.equals(emptyPtNC.getCondition().getExpression())) {
//											emptyPtSucc.add(nc);
//											timerConnect.eSet(
//													MapPackage.Literals.PATH_NODE.getEStructuralFeature("pred"),
//													emptyPtSucc);
//											connectedOrFork = true;
//										}
//									}
//								}
//								int emptyPtSuccIndex = emptyPtPred.getSucc().indexOf(emptyPtNC);
//								List<NodeConnection> timerPredList = new ArrayList<NodeConnection>();
//								timerPredList.add((NodeConnection) emptyPtPred.getSucc().get(emptyPtSuccIndex));
//								if (!connectedOrFork) {
//									timerConnect.eSet(MapPackage.Literals.PATH_NODE.getEStructuralFeature("pred"),
//											timerPredList);
//								}
//								List<NodeConnection> emptyPtNCs = emptyPt.getSucc();
//								emptyPtNCs.add((NodeConnection) timerSucc.getPred().get(0));
//
//								NodeConnection connectNC = (NodeConnection) connect.getSucc().get(0);
//								IURNNode connectSucc = connectNC.getTarget();
//								int connectSuccIndex = connectSucc.getPred().indexOf(connectNC);
//								List<NodeConnection> connectSuccList = new ArrayList<NodeConnection>();
//								connectSuccList.add((NodeConnection) connectSucc.getPred().get(connectSuccIndex));
//								timerConnect.eSet(MapPackage.Literals.PATH_NODE.getEStructuralFeature("succ"),
//										connectSuccList);
//
//								NodeConnection newNcforTimer = mapFactory.createNodeConnection();
//								map.getConnections().add(newNcforTimer);
//								timerConnect.getPred().add(newNcforTimer);
//
//								List<NodeConnection> connectList = new ArrayList<NodeConnection>();
//								connectList.add(newNcforTimer);
//								connect.eSet(MapPackage.Literals.PATH_NODE.getEStructuralFeature("succ"), connectList);
//							} else {
//								NodeConnection emptyPtNC = (NodeConnection) emptyPt.getPred().get(0);
//								IURNNode emptyPtPred = emptyPtNC.getSource();
//								timerConnect.getPred().addAll(emptyPtPred.getSucc());
//								iter.remove();
//								// nodes.remove(emptyPt);
//							}
//
//						}
//
//					}
//				}

				// Bind longboundelements to respective components
				String from = "";
				String to = "";
				ComponentRef contRef = null;
				PathNode firstNode = null;
				RespRef rf = null;
				for (Object cr : map.getContRefs()) {
					// System.out.println("check map name: "+map.eClass().getName());

					ComponentRef cRef = (ComponentRef) cr;
					if (!cRef.getMetadata().isEmpty()) {
						Iterator<Metadata> it = cRef.getMetadata().iterator();
						while (it.hasNext()) {
							Metadata md = (Metadata) it.next();
							if (md.getName().equals("from"))
								from = md.getValue();
							else
								to = md.getValue();
							contRef = cRef;
							it.remove();

							List<IURNNode> elemsToAdd = new ArrayList<IURNNode>();
							if (from != "" && to != "") {
								for (Object node : map.getNodes()) {
									PathNode nd = (PathNode) node;
									if (nd.eClass().getName().equals("RespRef")) {
										rf = (RespRef) nd;
										if (rf.getContRef() == null && rf.getRespDef().getName().equals(from)) {
											firstNode = rf;
										}
									} else if (nd.getName().equals(from))
										firstNode = nd;
									if (firstNode != null) {
										nd = firstNode;
										contRef.getNodes().add(nd);
										while (true) {
											if (nd.eClass().getName().equals("OrFork")
													|| nd.eClass().getName().equals("AndFork")
													|| nd.eClass().getName().equals("Timer")) {
												elemsToAdd.addAll(addNodesInOrFork(nd, to));
												break;
											}
											NodeConnection nc = (NodeConnection) nd.getSucc().get(0);
											if (nc.getTarget().getContRef() == null) {
												contRef.getNodes().add(nc.getTarget());
											}
											nd = (PathNode) nc.getTarget();
											if (nd.getName().equals(to))
												break;

										}
										contRef.getNodes().addAll(elemsToAdd);
									}
								}
								from = to = "";
							}
						}
					}
				}

				// Check for CONNECTS
				for (ListIterator<IURNNode> iter = nodes.listIterator(); iter.hasNext();) {
					IURNNode node = iter.next();
					if ((node.eClass().getName().equals("Connect"))) {
						// add connect
						if (contRef != null) {
							contRef.getNodes().add(node);
							// add pred of connect (e.g. an Endpoint)
							NodeConnection pred = (NodeConnection) node.getPred().get(0);
							contRef.getNodes().add(pred.getSource());
							// add succ of connect (e.g. a Timer)
							NodeConnection succ = (NodeConnection) node.getSucc().get(0);
							contRef.getNodes().add(succ.getTarget());
						}
					}
				}
			}
			// save the modified resource
			resource.save(new FileOutputStream(outFile), new HashMap<Object, Object>());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Timer getTimer(List<IURNNode> nodes, String connectedTimerName) {
		for (ListIterator<IURNNode> iter2 = nodes.listIterator(); iter2.hasNext();) {
			IURNNode timerNode = iter2.next();
			if (timerNode.eClass().getName().equals("Timer")) {
				Timer timer = (Timer) timerNode;
				if (timer.getName() != null && timer.getName().equals(connectedtimerName)) {
					return timer;
				}
			}
		}
		
		return null;
	}

	public static List<IURNNode> addNodesInOrFork(PathNode nd, String to) {
		List<IURNNode> elemsToAdd = new ArrayList<IURNNode>();
		for (Object succ : nd.getSucc()) {
			while (true) {
				NodeConnection nc = (NodeConnection) succ;
				elemsToAdd.add(nc.getTarget());
				nd = (PathNode) nc.getTarget();
				if (nd.getName().equals(to))
					return elemsToAdd;
				if (nd.eClass().getName().equals("EndPoint") && !nd.getName().equals("to")) {
					elemsToAdd = new ArrayList<IURNNode>();
					break;
				}
				if (nd.eClass().getName().equals("OrFork") || nd.eClass().getName().equals("AndFork")
						|| nd.eClass().getName().equals("Timer")) {
					List<IURNNode> list = addNodesInOrFork(nd, to);
					elemsToAdd.addAll(list);
					if (list.size() != 0)
						return elemsToAdd;
					break;
				} else
					succ = nd.getSucc().get(0);
			}
		}
		// change this
		return elemsToAdd;
	}

}
