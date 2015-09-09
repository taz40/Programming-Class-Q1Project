package com.samuel.programming.Q1.project.main;

import com.samuel.programming.Q1.project.references.Reference;

public class Main {
	
	public static void main(String[] args){
		new Main();
	}
	
	public Main(){
		System.out.println("The name of this project is " + Reference.projectName);
		System.out.println("Version: " + Reference.version);
	}

}
