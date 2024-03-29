////////////////////////////////////////////////////////////
/////
/////  A Visualisation Tool for
/////  Selection Hyper-Heuristics
/////
/////  http://code.google.com/p/vch/
/////
/////  Group:			gp09-exo
/////  FullNames:		Thomas Barton (txb18u)
/////					Zhang Chao (cxz09u)
/////					Ben Jenkinson (bxj08u)
/////					Alexander Jermstad (asj08u)
/////					Lao Jingqi (jxl29u)
/////
/////  Module:			G52GRP, University of Nottingham
/////
////////////////////////////////////////////////////////////


import java.util.Random;


public class VSH {
	HyperHeuristic hyperHeuristic;
	VSHMainFrame frame;
	HyperHeuristicBuilder HHBuilder;
	HyperHeuristicDirector HHDirector;
	Random random = new Random();
	int candidateSolution [] = new int[HyperHeuristic.DIGIT_NUM];
	int newSolution[] = new int[candidateSolution.length];
	LowLevelHeuristic lowLevelHeuristic;
	int count = 0;
	int [][] history = new int[10000][15];
	int bestSolution[] = new int[HyperHeuristic.DIGIT_NUM]; 
	int sleepTime = 1;
	String functionNmae = "f(x)=x^2", acceptanceMethodName = "Improving or Equal", heuristicSelectionName = "Simple Random";
	String [] lowLevelHeuristicNames = {"Reverse","Inverse","Shift","Flip One Bit","Steepest Gradient"};
	public static void main(String[] args){

		new VSH().start();
	}


	void start(){
		frame =new VSHMainFrame("VSH",this);
		for(;;){
			if(!frame.start){
				frame.stop();
			}
			count++;
			calculate();

			while(!frame.panel.m_panel.animationPanel.animationFinished){
				if(frame.pause){
					frame.stop();
				}
				if(frame.stop){
					frame.panel.m_panel.animationPanel.reset();
					break;
				}
				exhibition();
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			acceptanceCheck();
		}
	}


	void buildHyperHeuristic(){

		// Print out all the low-level heuristics.
		//System.Out.println("Available LowLevelHeuristics:");
		for(int i=0;i<lowLevelHeuristicNames.length;i++){
			//System.Out.println( "  " + lowLevelHeuristicNames[i] );
		}

		HHBuilder= new HyperHeuristicBuilder();
		HHDirector = new HyperHeuristicDirector(HHBuilder);
		HHDirector.construct(functionNmae, acceptanceMethodName, lowLevelHeuristicNames, heuristicSelectionName);
		hyperHeuristic = HHBuilder.GetHyperHeuristic();
		for(int i =0; i<candidateSolution.length;i++){
			candidateSolution[i] = random.nextInt(2);
			history[0][i]=candidateSolution[i];
			bestSolution[i]=candidateSolution[i];
		}


	}

	void calculate(){

		lowLevelHeuristic = hyperHeuristic.heuristicsSelection.selectLowLevelHeuristic(candidateSolution);

		//System.Out.println( "calculate->" + lowLevelHeuristic.getName() );

		if(hyperHeuristic.heuristicsSelection.getName().equals("Greedy Random")){
			newSolution = ((GreedyRandom)hyperHeuristic.heuristicsSelection).optimumSolution;
		}else{
			newSolution= lowLevelHeuristic.generateNewSolution(candidateSolution);

		}
		for(int i=0;i<newSolution.length;i++){
			history[count][i] = newSolution[i];
		}
		frame.panel.m_panel.animationPanel.animationFinished = false;

	}

	void exhibition(){
		frame.panel.m_panel.animationPanel.repaint();
	}
	void acceptanceCheck(){
		if(hyperHeuristic.acceptanceMethod.checkIfAcceptance(candidateSolution, newSolution)){
			candidateSolution = newSolution;
			if(hyperHeuristic.heuristicsSelection.getName().equals("Reinforcement Learning"))
				((ReinforcementLearning)hyperHeuristic.heuristicsSelection).incrementScore();
		}else{
			if(hyperHeuristic.heuristicsSelection.getName().equals("Reinforcement Learning"))
				((ReinforcementLearning)hyperHeuristic.heuristicsSelection).decrementScore();
		}
	}
}