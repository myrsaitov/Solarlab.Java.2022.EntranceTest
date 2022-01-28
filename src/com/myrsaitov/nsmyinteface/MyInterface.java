package com.myrsaitov.nsmyinteface;

import com.myrsaitov.nsmylist.MyList;

import java.io.IOException;

public class MyInterface
{

	public MyInterface()
	{

	}

	public final void MainScreen(MyList MyListObj) throws IOException {
		//Runtime.getRuntime().exec("cls");
		System.out.println("Wellcome to Congratulator!");
		//MyListObj.SelectedShow();
		System.out.println("________________________________________________");
		System.out.println();
		MyListObj.Show();


		System.out.println();
		System.out.println("________________________________________________");
		System.out.println("Enter \"U\"(up) or \"J\"(down) to Select Note");
		System.out.println("Enter \"A\" to Add Note");
		System.out.println("Enter \"R\" to Remove Note");
		System.out.println("Enter \"E\" to Edit Note");
		System.out.println("Enter \"S\" to Save File (not implemeted in this version)");
		System.out.println("Enter \"L\" to Load File (not implemeted in this version)");
		System.out.println();
		System.out.println("Enter \"X\" to Exit");

	}


	public final void MyReadKey(MyList MyListObj) throws IOException {
		while (true)
		{
			var Key = System.in.read();

			if (Key == 85) //UpArrow - U
			{
				MyListObj.SelectUp();
				MainScreen(MyListObj);
			}

			if (Key == 74) //DownArrow -J
			{
				MyListObj.SelectDown();
				MainScreen(MyListObj);
			}

			if (Key == 65) //A
			{
				MyListObj.Add();
				MainScreen(MyListObj);
			}

			if (Key == 82) //R
			{
				MyListObj.Remove();
				MainScreen(MyListObj);
			}

			if (Key == 69) //E
			{
				MyListObj.Edit();
				MainScreen(MyListObj);
			}

			if (Key == 88) //X
			{
				System.out.print("Exit Program!");
				break;
			}
		}
	}
}