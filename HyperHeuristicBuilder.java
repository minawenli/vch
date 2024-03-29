
public class HyperHeuristicBuilder {

	HyperHeuristic hyperHeuristic = new HyperHeuristic();
	public void buildFunction(String name) {
		// TODO Auto-generated method stub
		hyperHeuristic.function = FunctionFactory.createFunction(name);
	}

	public void buildAcceptanceMethod(String name) {
		// TODO Auto-generated method stub
		hyperHeuristic.acceptanceMethod =AcceptanceMethodFactory.createAcceptanceMethod(name,hyperHeuristic);
	}

	public  LowLevelHeuristic LowLevelHeuristic(String name) {
		// TODO Auto-generated method stub
		return LowLevelHeuristicsFactory.createLowLevelHeuristic(name,hyperHeuristic);
	}

	public void LowLevelHeuristics(String[] names) {
		// TODO Auto-generated method stub
		for(int i=0;i<names.length;i++){
			hyperHeuristic.lowLevelHeuristics.add(LowLevelHeuristic(names[i]));
		}
		
	}
	public void HeuristicsSelection(String name) {
		// TODO Auto-generated method stub
		hyperHeuristic.heuristicsSelection = HeuristicsSelectionFactory.createHeuristicsSelection(name,hyperHeuristic);
		
	}
	
	public HyperHeuristic GetHyperHeuristic(){
		return hyperHeuristic;
	}

}
