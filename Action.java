import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;




public class Action implements ActionListener{
	VSHMainFrame frame;
	JButton button;

	Config con ;
	Dimension sdm ;

	String img_dir = "skin";


	Action(VSHMainFrame f,JButton btn)
	{
		this.frame = f;
		this.button = btn;

		con = new Config();

		img_dir = con.getSkinDir();

		sdm = con.getScreenSize();
	}
	public Action(VSHMainFrame f) {
		// TODO Auto-generated constructor stub
		this.frame = f1;
	}

	public void actionPerformed(ActionEvent e)
	{



		 if(e.getActionCommand().equals("cmd_min"))
		{
			frame.setExtendedState(frame.ICONIFIED|frame.getExtendedState());
		}else if(e.getActionCommand().equals("min_info"))
		{
			frame.info.setExtendedState(frame.info.ICONIFIED|frame.info.getExtendedState());
		}else if(e.getActionCommand().equals("min_help"))
		{
			frame.help.setExtendedState(frame.help.ICONIFIED|frame.help.getExtendedState());
		}

		else if(e.getActionCommand().equals("cmd_close"))
		{
			System.exit(0);
		}
		else if(e.getActionCommand().equals("close_info"))
		{
			frame.info.dispose();
			frame.info = null;
		}		else if(e.getActionCommand().equals("close_help"))
		{
			frame.help.dispose();
			frame.help = null;
		}



		else if(e.getActionCommand().equals("Benchmark Function")){
			if(frame.panel.m_panel.initalMenuPanel.benchmarkFunctionMenu)
				return;

			frame.panel.m_panel.p_left.menuPanelInUpPanel.removeAll();

			frame.panel.m_panel.p_left.menuPanelInUpPanel.add(frame.panel.m_panel.p_left.squareFunction);
			frame.panel.m_panel.p_left.menuPanelInUpPanel.add(frame.panel.m_panel.p_left.sinFunction);
			frame.panel.m_panel.p_left.menuPanelInUpPanel.add(frame.panel.m_panel.p_left.logFunction);
			frame.panel.m_panel.initalMenuPanel.benchmarkFunctionMenu = true;
			frame.panel.m_panel.initalMenuPanel.heuristicSelectionMenu = false;
			frame.panel.m_panel.initalMenuPanel.lowLevelHeuristicsMenu = false;
			frame.panel.m_panel.initalMenuPanel.acceptanceMethodMenu = false;
			frame.update(frame.getGraphics());
			frame.validate();
		}

		else if(e.getActionCommand().equals("Heuristic Selection")){
			if(frame.panel.m_panel.initalMenuPanel.heuristicSelectionMenu)
				return;
			frame.panel.m_panel.p_left.menuPanelInUpPanel.removeAll();
			frame.panel.m_panel.p_left.menuPanelInUpPanel.add(frame.panel.m_panel.p_left.simpleRandom);
			frame.panel.m_panel.p_left.menuPanelInUpPanel.add(frame.panel.m_panel.p_left.greedyRandom);
			frame.panel.m_panel.p_left.menuPanelInUpPanel.add(frame.panel.m_panel.p_left.reinforcementLearning);

			frame.panel.m_panel.initalMenuPanel.heuristicSelectionMenu = true;
			frame.panel.m_panel.initalMenuPanel.benchmarkFunctionMenu = false;
			frame.panel.m_panel.initalMenuPanel.lowLevelHeuristicsMenu = false;
			frame.panel.m_panel.initalMenuPanel.acceptanceMethodMenu = false;
			frame.update(frame.getGraphics());
			frame.validate();
		}


		else if(e.getActionCommand().equals("Low Level Heuristics")){
			if(frame.panel.m_panel.initalMenuPanel.lowLevelHeuristicsMenu)
				return;
			frame.panel.m_panel.p_left.menuPanelInUpPanel.removeAll();
			frame.panel.m_panel.p_left.menuPanelInUpPanel.add(frame.panel.m_panel.p_left.inverse);
			frame.panel.m_panel.p_left.menuPanelInUpPanel.add(frame.panel.m_panel.p_left.reverse);
			frame.panel.m_panel.p_left.menuPanelInUpPanel.add(frame.panel.m_panel.p_left.shift);
			frame.panel.m_panel.p_left.menuPanelInUpPanel.add(frame.panel.m_panel.p_left.flipOneBit);
			frame.panel.m_panel.p_left.menuPanelInUpPanel.add(frame.panel.m_panel.p_left.steepestGradient);

			frame.panel.m_panel.initalMenuPanel.heuristicSelectionMenu = false;
			frame.panel.m_panel.initalMenuPanel.benchmarkFunctionMenu = false;
			frame.panel.m_panel.initalMenuPanel.lowLevelHeuristicsMenu = true;
			frame.panel.m_panel.initalMenuPanel.acceptanceMethodMenu = false;
			frame.update(frame.getGraphics());
			frame.validate();
		}

		else if(e.getActionCommand().equals("Acceptance Method")){
			if(frame.panel.m_panel.initalMenuPanel.acceptanceMethodMenu)
				return;
			frame.panel.m_panel.p_left.menuPanelInUpPanel.removeAll();
			frame.panel.m_panel.p_left.menuPanelInUpPanel.add(frame.panel.m_panel.p_left.onlyImproving);
			frame.panel.m_panel.p_left.menuPanelInUpPanel.add(frame.panel.m_panel.p_left.improvingEqual);

			frame.panel.m_panel.p_left.menuPanelInUpPanel.add(frame.panel.m_panel.p_left.allMovesAccepted);

			frame.panel.m_panel.initalMenuPanel.heuristicSelectionMenu = false;
			frame.panel.m_panel.initalMenuPanel.benchmarkFunctionMenu = false;
			frame.panel.m_panel.initalMenuPanel.lowLevelHeuristicsMenu = false;
			frame.panel.m_panel.initalMenuPanel.acceptanceMethodMenu = true;
			frame.update(frame.getGraphics());
			frame.validate();
		}


		else if(e.getActionCommand().equals("confirm")){
			if(frame.panel.m_panel.initalMenuPanel.benchmarkFunctionMenu){
				if(frame.panel.m_panel.p_left.squareFunction.isSelected()){
					frame.panel.m_panel.initalMenuPanel.benchmarkFunctionInfo.setText("f(x) = x ^ 2");
					frame.vsh.functionNmae = "f(x)=x^2";
				}else if(frame.panel.m_panel.p_left.sinFunction.isSelected()){
					frame.panel.m_panel.initalMenuPanel.benchmarkFunctionInfo.setText("f(x) = sin (x*PI/10000)");
					frame.vsh.functionNmae = "f(x)=sinx";
				}else if(frame.panel.m_panel.p_left.logFunction.isSelected()){
					frame.panel.m_panel.initalMenuPanel.benchmarkFunctionInfo.setText("f(x) = log (x+1)");
					frame.vsh.functionNmae = "f(x)=logx";
				}

			}else if(frame.panel.m_panel.initalMenuPanel.heuristicSelectionMenu){
				if(frame.panel.m_panel.p_left.simpleRandom.isSelected()){
					frame.panel.m_panel.initalMenuPanel.heuristicSelectionInfo.setText("Simple Random");
					frame.vsh.heuristicSelectionName = "Simple Random";
				}else if(frame.panel.m_panel.p_left.greedyRandom.isSelected()){
					frame.panel.m_panel.initalMenuPanel.heuristicSelectionInfo.setText("Greedy Random");
					frame.vsh.heuristicSelectionName = "Greedy Random";
				}else if(frame.panel.m_panel.p_left.reinforcementLearning.isSelected()){
					frame.panel.m_panel.initalMenuPanel.heuristicSelectionInfo.setText("Reinforcement Learning");
					frame.vsh.heuristicSelectionName = "Reinforcement Learning";
				}
			}else if(frame.panel.m_panel.initalMenuPanel.lowLevelHeuristicsMenu){
				String output = "";
				Vector <String> names = new Vector <String>();
				if(frame.panel.m_panel.p_left.inverse.isSelected()){
					frame.panel.m_panel.p_left.countLowLevelHeuristics++;
					output = "" + "Inverse";
					names.add("Inverse");
				}
				if(frame.panel.m_panel.p_left.reverse.isSelected()){
					names.add("Reverse");
					frame.panel.m_panel.p_left.countLowLevelHeuristics++;
					if(!output.equals(""))
						output = "Inverse, Reverse";
					else
						output = "" + "Reverse";
				}
				if(frame.panel.m_panel.p_left.shift.isSelected()){
					names.add("Shift");
					if(!output.equals(""))
							output =  output +",Shift";
					else
						output = "" + "Shift";
					frame.panel.m_panel.p_left.countLowLevelHeuristics++;

				}
				if(frame.panel.m_panel.p_left.flipOneBit.isSelected()){
					names.add("Flip One Bit");
					if(!output.equals("")){
						if(frame.panel.m_panel.p_left.countLowLevelHeuristics==2){
							output = output +",Flip One Bit";
						}else if(frame.panel.m_panel.p_left.countLowLevelHeuristics==3){
							output = "<html><p>Inverse,Reverse,Flip One Bit</p></p>Shift</p></html>";
						}else if(frame.panel.m_panel.p_left.countLowLevelHeuristics==1){
							output = output +",Flip One Bit";
						}
					}else
						output = "" + "Flip One Bit";

					frame.panel.m_panel.p_left.countLowLevelHeuristics++;
				}
				if(frame.panel.m_panel.p_left.steepestGradient.isSelected()){
					names.add("Steepest Gradient");
					if(!output.equals("")){
						if(frame.panel.m_panel.p_left.countLowLevelHeuristics==2){
							output = "<html><p>"+output +",</p></p>Steepest Gradient</p></html>";
						}else if(frame.panel.m_panel.p_left.countLowLevelHeuristics==3){
							output = "<html><p>Inverse,Reverse</p></p>Shift,Steepest Gradient</p></html>";
						}else if(frame.panel.m_panel.p_left.countLowLevelHeuristics==1){
							if(frame.panel.m_panel.p_left.flipOneBit.isSelected())
								output = "<html><p>"+output +",</p></p>Steepest Gradient</p></html>";
							else
								output = output+",Steepest Gradient";
						}else if(frame.panel.m_panel.p_left.countLowLevelHeuristics==4){
							output = "<html><p>Inverse,Reverse,Flip One Bit</p></p>Shift,Steepest Gradient</p></html>";
						}
					}else
						output = "" + "Steepest Gradient";
				}
				String[] lowLevelHeuristicNames = new String[names.size()];
				for(int i=0;i<names.size();i++){
					lowLevelHeuristicNames[i] = names.get(i);
				}
				frame.vsh.lowLevelHeuristicNames = lowLevelHeuristicNames;
				frame.panel.m_panel.p_left.countLowLevelHeuristics = 0;
				frame.panel.m_panel.initalMenuPanel.lowLevelHeuristicsInfo.setText(output);
			}else if(frame.panel.m_panel.initalMenuPanel.acceptanceMethodMenu){
				if(frame.panel.m_panel.p_left.onlyImproving.isSelected()){
					frame.vsh.acceptanceMethodName = "Only Improving";
					frame.panel.m_panel.initalMenuPanel.acceptanceMethodInfo.setText("Only Improving");
				}else if(frame.panel.m_panel.p_left.improvingEqual.isSelected()){
					frame.vsh.acceptanceMethodName = "Improving or Equal";
					frame.panel.m_panel.initalMenuPanel.acceptanceMethodInfo.setText("Improving and Equal");
				}else if(frame.panel.m_panel.p_left.allMovesAccepted.isSelected()){
					frame.vsh.acceptanceMethodName = "All Moves Accepted";
					frame.panel.m_panel.initalMenuPanel.acceptanceMethodInfo.setText("All Moves Accepted");
				}
			}


		}else if(e.getActionCommand().equals("play")){
			frame.panel.m_panel.initalMenuPanel.benchmarkFunction.setEnabled(false);
			frame.panel.m_panel.initalMenuPanel.heuristicSelection.setEnabled(false);
			frame.panel.m_panel.initalMenuPanel.lowLevelHeuristics.setEnabled(false);
			frame.panel.m_panel.initalMenuPanel.acceptanceMethod.setEnabled(false);
			frame.panel.m_panel.p_left.confirm.setEnabled(false);
			frame.panel.m_panel.p_left.menuPanelInUpPanel.removeAll();
			frame.panel.m_panel.p_left.menuPanelInUpPanel.add(frame.panel.m_panel.p_left.logo);
			frame.panel.m_panel.p_left.confirmationPanelInUpPanel.setVisible(false);
			if(!frame.start&&frame.stop){
				frame.vsh.buildHyperHeuristic();
			}
			if(!frame.panel.m_panel.animationPanel.drawBackgroundPic )
				frame.panel.m_panel.animationPanel.removeAll();
			frame.panel.m_panel.animationPanel.drawBackgroundPic = true;
			frame.update(frame.getGraphics());
			frame.validate();
			frame.stop = false;
			frame.play();
			frame.pause = false;
			frame.start = true;
			frame.panel.pause.setIcon(con.getImgUrl("menu-button-pause.png"));
			frame.panel.play.setIcon(con.getImgUrl("menu-button-play-hover.png"));

		}else if(e.getActionCommand().equals("pause")){
			frame.pause = true;
			frame.panel.play.setIcon(con.getImgUrl("menu-button-play.png"));
			frame.panel.pause.setIcon(con.getImgUrl("menu-button-pause-hover.png"));
		}else if(e.getActionCommand().equals("stop")){
			frame.panel.m_panel.initalMenuPanel.benchmarkFunction.setEnabled(true);
			frame.panel.m_panel.initalMenuPanel.heuristicSelection.setEnabled(true);
			frame.panel.m_panel.initalMenuPanel.lowLevelHeuristics.setEnabled(true);
			frame.panel.m_panel.initalMenuPanel.acceptanceMethod.setEnabled(true);
			frame.panel.m_panel.p_left.menuPanelInUpPanel.removeAll();
			frame.panel.m_panel.p_left.menuPanelInUpPanel.add(frame.panel.m_panel.p_left.squareFunction);
			frame.panel.m_panel.p_left.menuPanelInUpPanel.add(frame.panel.m_panel.p_left.sinFunction);
			frame.panel.m_panel.p_left.menuPanelInUpPanel.add(frame.panel.m_panel.p_left.logFunction);
			frame.panel.m_panel.initalMenuPanel.benchmarkFunctionMenu = true;
			frame.panel.m_panel.initalMenuPanel.heuristicSelectionMenu = false;
			frame.panel.m_panel.initalMenuPanel.lowLevelHeuristicsMenu = false;
			frame.panel.m_panel.initalMenuPanel.acceptanceMethodMenu = false;
			frame.panel.m_panel.p_left.confirmationPanelInUpPanel.setVisible(true);
			frame.update(frame.getGraphics());
			frame.validate();
				
			//frame.panel.m_panel.p_left.confirm.setEnabled(true);
			frame.start = false;
			frame.stop = true;
			frame.vsh.sleepTime = 10;
			if(frame.pause)
			frame.play();

		} else if(e.getActionCommand().equals("speed up")){

			// Speed-up button pressed.

			if(frame.start){

				// As long as it's not already zero.
				if(frame.vsh.sleepTime!=0) {

					// Decrease the time between frames.
					frame.vsh.sleepTime--;

				} // END if

			} // END if

		} else if(e.getActionCommand().equals("slow down")){

			// Slow-down button pressed.

			if(frame.start) {

				// Increase the time between frames.
				frame.vsh.sleepTime++;

			} // END if

		} else if( e.getActionCommand().equals("info") ) {
			if(frame.info==null)
			frame.createInfoFrame();
			// Someone pressed the "Information" button on the main menu.
			//System.Out.println("Action->info");

		} else if( e.getActionCommand().equals("help") ) {
			if(frame.help==null)
			frame.createHelpFrame();
			// Someone pressed the "Help" button on the main menu.
			//System.out.println("Action->help");

		}else if(e.getActionCommand().equals("Square Function")){
			if(!frame.start){
				if(!frame.panel.m_panel.initalMenuPanel.benchmarkFunctionInfo.getText().equals("f(x) = x ^ 2"))
				frame.panel.m_panel.p_left.confirm.setEnabled(true);;
			}
		}else if(e.getActionCommand().equals("Sin Function")){
			if(!frame.start){
				if(!frame.panel.m_panel.initalMenuPanel.benchmarkFunctionInfo.getText().equals("f(x) = sin (x*PI/10000)"))
					frame.panel.m_panel.p_left.confirm.setEnabled(true);;

			}
		}else if(e.getActionCommand().equals("Log Function")){
			if(!frame.start){
				if(!frame.panel.m_panel.initalMenuPanel.benchmarkFunctionInfo.getText().equals("f(x) = log (x+1)"))
				frame.panel.m_panel.p_left.confirm.setEnabled(true);;
			}
		}else if(e.getActionCommand().equals("Simple Random")){
			if(!frame.start){
				if(!frame.panel.m_panel.initalMenuPanel.benchmarkFunctionInfo.getText().equals("Simple Random"))
				frame.panel.m_panel.p_left.confirm.setEnabled(true);;
			}
		}else if(e.getActionCommand().equals("Greedy Random")){
			if(!frame.start){
				if(!frame.panel.m_panel.initalMenuPanel.benchmarkFunctionInfo.getText().equals("Greedy Random"))
				frame.panel.m_panel.p_left.confirm.setEnabled(true);;
			}
		}else if(e.getActionCommand().equals("Reinforcement Learning")){
			if(!frame.start){
				if(!frame.panel.m_panel.initalMenuPanel.benchmarkFunctionInfo.getText().equals("Reinforcement Learning"))
				frame.panel.m_panel.p_left.confirm.setEnabled(true);;
			}
		}else if(e.getActionCommand().equals("Only Improving")){
			if(!frame.start){
				if(!frame.panel.m_panel.initalMenuPanel.benchmarkFunctionInfo.getText().equals("Only Improving"))
				frame.panel.m_panel.p_left.confirm.setEnabled(true);;
			}
		}else if(e.getActionCommand().equals("Improving or Equal")){
			if(!frame.start){
				if(!frame.panel.m_panel.initalMenuPanel.benchmarkFunctionInfo.getText().equals("Improving and Equal"))
				frame.panel.m_panel.p_left.confirm.setEnabled(true);;
			}
		}else if(e.getActionCommand().equals("All Moves Accepted")){
			if(!frame.start){
				if(!frame.panel.m_panel.initalMenuPanel.benchmarkFunctionInfo.getText().equals("All Moves Accepted"))
				frame.panel.m_panel.p_left.confirm.setEnabled(true);;
			}
		}else if(e.getActionCommand().equals("Inverse")){
			if(!frame.start){
				frame.panel.m_panel.p_left.confirm.setEnabled(true);;
			}
		}else if(e.getActionCommand().equals("Reverse")){
			if(!frame.start){
				frame.panel.m_panel.p_left.confirm.setEnabled(true);;
			}
		}else if(e.getActionCommand().equals("Shift")){
			if(!frame.start){
				frame.panel.m_panel.p_left.confirm.setEnabled(true);;
			}
		}else if(e.getActionCommand().equals("Flip One Bit")){
			if(!frame.start){
				frame.panel.m_panel.p_left.confirm.setEnabled(true);;
			}
		}else if(e.getActionCommand().equals("Steepest Gradient")){
			if(!frame.start){
				frame.panel.m_panel.p_left.confirm.setEnabled(true);;
			}
		}

	}

}
