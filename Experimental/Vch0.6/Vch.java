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
/////  CreationDate: 	2010-02-15
/////  Module:			G52GRP, University of Nottingham
/////
////////////////////////////////////////////////////////////



// IMPORT LIBRARIES

import java.io.*;
import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.*;



public class Vch {
	
	// Are we in Debug mode?
	boolean inDebugMode = true;
	
	
	
	// GLOBAL VARIABLES
	Problem problem;	
	
	
	// CONSTRUCTOR

	public Vch() {
				
		// Hooray, someone's using our program.
		printDebugMessage( "Vch()" );
		
		// Create a new problem.
		problem = new Problem( this );
		
		problem.start();
		
	} // END constructor Vch()
	
	
	
	// METHODS
	
	public void printDebugMessage( String message ) {
		
		// Checks for debug mode and then prints the string.
		if ( this.inDebugMode ) {
			
			System.out.println( message );
			
		} // END if
		
	} // END printDebugMessage( String message )
	
	public int getMaximumValue() {
		
		// Returns the maximum value that the problem function can produce.
		return this.problem.getMaximumValue();
		
	} // END getMaximumValue() method
	
	
	
	// LISTENERS
	
	
	
	// MAIN PROGRAM

	public static void main( String args[] ) {

		// Start a new application instance, window and all.
		Vch vch = new Vch();

	} // END main
	
} // END class Vch