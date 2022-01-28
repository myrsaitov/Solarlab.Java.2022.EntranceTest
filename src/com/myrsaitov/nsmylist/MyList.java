package com.myrsaitov.nsmylist;

import com.myrsaitov.nscongratulation.Congratulation;

import java.io.Console;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;

public class MyList
{
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static int tryParseInt(String s)
	{
		try
		{
			return Integer.parseInt(s);
		}
		catch (NumberFormatException e)
		{
			return 0;
		}
	}

	public final void Add() throws IOException {

		System.out.println("Add new Item:");
		System.out.println();

		System.out.print("Description: ");
		String AddDescription = new Scanner(System.in).nextLine();

		String Input;
		boolean RES = true;

		System.out.print("Year: ");
		Input = new Scanner(System.in).nextLine();
		int Year = -1;



		//tangible.OutObject<Integer> tempOut_Year = new tangible.OutObject<Integer>();
		//RES &= tangible.TryParseHelper.tryParseInt(Input, tempOut_Year);
	Year = tryParseInt(Input);

		System.out.print("Month: ");
		Input = new Scanner(System.in).nextLine();
		int Month = -1;
	Month = tryParseInt(Input);

		System.out.print("Day: ");
		Input = new Scanner(System.in).nextLine();
		int Day = -1;
	Day = tryParseInt(Input);

		System.out.print("Hour: ");
		Input = new Scanner(System.in).nextLine();
		int Hour = -1;
	Hour = tryParseInt(Input);

		System.out.print("Minute: ");
		Input = new Scanner(System.in).nextLine();
		int Minute = -1;
	Minute = tryParseInt(Input);

		System.out.print("Second: ");
		Input = new Scanner(System.in).nextLine();
		int Second = -1;
	Second = tryParseInt(Input);

		if (!RES)
		{
			System.out.println();
			System.out.println("Error!");
			System.out.println("USE Only 0 ... 9 Symbols!: ");
			System.out.println();
			System.out.println("Press ANY key to Continue!");

			do
			{
				int num1 = System.in.read();
				if (num1 != 0)
				{
					break;
				}

			} while (true);

		}
		else
		{


			int Test = 0;

			System.out.println();

			if ((Year >= 1970) && (Year <= 2100))
			{
				Test++;
			}
			else
			{
				System.out.println("TimeStamp Input Error: Invalid Year!");
			}

			if ((Month >= 1) && (Month <= 12))
			{
				Test++;
			}
			else
			{
				System.out.println("TimeStamp Input Error: Invalid Month!");
			}

			if ((Day >= 1) && (Day <= 31))
			{
				Test++;
			}
			else
			{
				System.out.println("TimeStamp Input Error: Invalid Day!");
			}

			if ((Hour >= 1) && (Hour <= 23))
			{
				Test++;
			}
			else
			{
				System.out.println("TimeStamp Input Error: Invalid Hour!");
			}

			if ((Minute >= 1) && (Minute <= 59))
			{
				Test++;
			}
			else
			{
				System.out.println("TimeStamp Input Error: Invalid Minute!");
			}

			if ((Second >= 1) && (Second <= 59))
			{
				Test++;
			}
			else
			{
				System.out.println("TimeStamp Input Error: Invalid Second!");
			}

			if (Test == 6)
			{
				LocalDateTime NewDateTime = LocalDateTime.of(Year, Month, Day, Hour, Minute, Second);
				double NewUnixTime = ConvertToUnixTimestamp(NewDateTime);
				Congratulation tempVar = new Congratulation();
				tempVar.setDescription(AddDescription);
				tempVar.setUnixTime(NewUnixTime);
				this.ListOfCongratulations.add(tempVar);
				this.AddedUnixTime = NewUnixTime;
			}
			else
			{
				System.out.println();
				System.out.println("Press ANY key to Continue!");
				int num = 0;
				do
				{
					num = System.in.read();
					if (num != 0)
					{
						break;
					}

				} while (true);
			}
		}
	}


	private int Selected = 0;
	private int EditIndex = 0;
	private double AddedUnixTime = 0;

	private ArrayList<Congratulation> ListOfCongratulations;
	public MyList()
	{
		Congratulation tempVar = new Congratulation();
		tempVar.setDescription("Ivanov");
		tempVar.setUnixTime(1581580800);
		Congratulation tempVar2 = new Congratulation();
		tempVar2.setDescription("Petrov");
		tempVar2.setUnixTime(1580821200);
		Congratulation tempVar3 = new Congratulation();
		tempVar3.setDescription("Sidorov");
		tempVar3.setUnixTime(1581962400);
		this.ListOfCongratulations = new ArrayList<Congratulation>(Arrays.asList(tempVar, tempVar2, tempVar3));
	}

	private static LocalDateTime ConvertFromUnixTimestamp(double timestamp)
	{
		LocalDateTime origin = LocalDateTime.of(1970, 1, 1, 0, 0, 0, 0);
		return origin.plusSeconds((long) timestamp);
	}
	private static double ConvertToUnixTimestamp(LocalDateTime date)
	{
		LocalDateTime origin = LocalDateTime.of(1970, 1, 1, 0, 0, 0, 0);
		//TimeSpan diff = date - origin;
//
		return Math.floor(0);
	}

	// Сравнивает две даты
	public static double CompareUnixTime(Congratulation plan1, Congratulation plan2)
	{
		return (plan1.getUnixTime() - plan2.getUnixTime());
	}

	// Выводит выбранный пункт
	public final void SelectedShow()
	{
		System.out.println(this.Selected);
	}

	// Выбирает пункт выше
	public final void SelectUp()
	{
		if (this.Selected > 0)
		{
			this.Selected--;
		}
	}

	// Выбирает пункт ниже
	public final void SelectDown()
	{
		if (this.Selected < this.ListOfCongratulations.size() - 1)
		{
			this.Selected++;
		}
	}





	private String AddDescription;
	private String Input;
	private boolean RES;
	private int Year;
	private int Month;
	private int Day;
	private int Hour;
	private int Minute;
	private int Second;

	public final void Edit() throws IOException {
		LocalDateTime DT = ConvertFromUnixTimestamp(this.ListOfCongratulations.get(this.Selected).getUnixTime());
		AddDescription = this.ListOfCongratulations.get(this.Selected).getDescription();
		//Console.Clear();
		System.out.println(/*DT.toString("yyyy/MM/dd HH:mm:ss") +*/ " " + AddDescription);
		System.out.println();
		System.out.println("Press to Edit:");
		System.out.println("1.  Year");
		System.out.println("2.  Month");
		System.out.println("3.  Day");
		System.out.println("4.  Hours");
		System.out.println("5.  Minutes");
		System.out.println("6.  Secons");
		System.out.println("D.  Description");
		System.out.println();
		System.out.println("X.  Abort and Exit");
		System.out.println();

		RES = true;
		/*Year = Integer.parseInt(DT.toString("yyyy"));
		Month = Integer.parseInt(DT.toString("MM"));
		Day = Integer.parseInt(String.format("%1$d", DT));
		Hour = Integer.parseInt(DT.toString("HH"));
		Minute = Integer.parseInt(DT.toString("mm"));
		Second = Integer.parseInt(DT.toString("ss"));*/

		while (true)
		{
			int Key = System.in.read();

			if (Key == 49) //1
			{
				EditD1();
				break;
			}

			if (Key == 50) //2
			{
				EditD2();
				break;
			}

			if (Key == 51) //3
			{
				EditD3();
				break;
			}

			if (Key == 52) //4
			{
				EditD4();
				break;
			}

			if (Key == 53) //5
			{
				EditD5();
				break;
			}

			if (Key == 54) //6
			{
				EditD6();
				break;
			}

			if (Key == 68) //D
			{

				EditD();
				break;
			}

			if (Key == 88) //X
			{
				break;
			}
		}
	}


	public final void EditD()
	{
		System.out.print("New Description: ");
		AddDescription = new Scanner(System.in).nextLine();

		if (!this.ListOfCongratulations.isEmpty())
		{
			this.ListOfCongratulations.remove(Selected);
		}

		LocalDateTime NewDateTime = LocalDateTime.of(Year, Month, Day, Hour, Minute, Second);
		double NewUnixTime = ConvertToUnixTimestamp(NewDateTime);
		Congratulation tempVar = new Congratulation();
		tempVar.setDescription(AddDescription);
		tempVar.setUnixTime(NewUnixTime);
		this.ListOfCongratulations.add(tempVar);
		this.AddedUnixTime = NewUnixTime;
	}


	public final void EditD1()
	{
		System.out.print("New Year: ");
		Input = new Scanner(System.in).nextLine();
	Year = tryParseInt(Input);
		if (!RES)
		{
			System.out.println("Input Error: Use only 0...9 symbols");
		}
		else if ((Year >= 1970) && (Year <= 2100))
		{
			if (!this.ListOfCongratulations.isEmpty())
			{
				this.ListOfCongratulations.remove(Selected);
			}

			LocalDateTime NewDateTime = LocalDateTime.of(Year, Month, Day, Hour, Minute, Second);
			double NewUnixTime = ConvertToUnixTimestamp(NewDateTime);
			Congratulation tempVar = new Congratulation();
			tempVar.setDescription(AddDescription);
			tempVar.setUnixTime(NewUnixTime);
			this.ListOfCongratulations.add(tempVar);
			this.AddedUnixTime = NewUnixTime;
		}
		else
		{
			System.out.println("TimeStamp Input Error: Invalid Year!");
		}

	}


	public final void EditD2()
	{
		System.out.print("New Month: ");
		Input = new Scanner(System.in).nextLine();
	Month = tryParseInt(Input);
		if (!RES)
		{
			System.out.println("Input Error: Use only 0...9 symbols");
		}
		else if ((Month >= 1) && (Month <= 12))
		{
			if (!this.ListOfCongratulations.isEmpty())
			{
				this.ListOfCongratulations.remove(Selected);
			}

			LocalDateTime NewDateTime = LocalDateTime.of(Year, Month, Day, Hour, Minute, Second);
			double NewUnixTime = ConvertToUnixTimestamp(NewDateTime);
			Congratulation tempVar = new Congratulation();
			tempVar.setDescription(AddDescription);
			tempVar.setUnixTime(NewUnixTime);
			this.ListOfCongratulations.add(tempVar);
			this.AddedUnixTime = NewUnixTime;
		}
		else
		{
			System.out.println("TimeStamp Input Error: Invalid Month!");
		}
	}


	public final void EditD3()
	{
		System.out.print("New Day: ");
		Input = new Scanner(System.in).nextLine();
	Day = tryParseInt(Input);
		if (!RES)
		{
			System.out.println("Input Error: Use only 0...9 symbols");
		}
		else if ((Day >= 1) && (Day <= 31))
		{
			if (!this.ListOfCongratulations.isEmpty())
			{
				this.ListOfCongratulations.remove(Selected);
			}

			LocalDateTime NewDateTime = LocalDateTime.of(Year, Month, Day, Hour, Minute, Second);
			double NewUnixTime = ConvertToUnixTimestamp(NewDateTime);
			Congratulation tempVar = new Congratulation();
			tempVar.setDescription(AddDescription);
			tempVar.setUnixTime(NewUnixTime);
			this.ListOfCongratulations.add(tempVar);
			this.AddedUnixTime = NewUnixTime;
		}
		else
		{
			System.out.println("TimeStamp Input Error: Invalid Day!");
		}
	}


	public final void EditD4()
	{
		System.out.print("New Hour: ");
		Input = new Scanner(System.in).nextLine();
	Hour = tryParseInt(Input);
		if (!RES)
		{
			System.out.println("Input Error: Use only 0...9 symbols");
		}
		else if ((Hour >= 0) && (Hour <= 23))
		{
			if (!this.ListOfCongratulations.isEmpty())
			{
				this.ListOfCongratulations.remove(Selected);
			}

			LocalDateTime NewDateTime = LocalDateTime.of(Year, Month, Day, Hour, Minute, Second);
			double NewUnixTime = ConvertToUnixTimestamp(NewDateTime);
			Congratulation tempVar = new Congratulation();
			tempVar.setDescription(AddDescription);
			tempVar.setUnixTime(NewUnixTime);
			this.ListOfCongratulations.add(tempVar);
			this.AddedUnixTime = NewUnixTime;
		}
		else
		{
			System.out.println("TimeStamp Input Error: Invalid Hour!");
		}
	}


	public final void EditD5()
	{
		System.out.print("New Minutes: ");
		Input = new Scanner(System.in).nextLine();
	Minute = tryParseInt(Input);
		if (!RES)
		{
			System.out.println("Input Error: Use only 0...9 symbols");
		}
		else if ((Minute >= 0) && (Minute <= 59))
		{
			if (!this.ListOfCongratulations.isEmpty())
			{
				this.ListOfCongratulations.remove(Selected);
			}

			LocalDateTime NewDateTime = LocalDateTime.of(Year, Month, Day, Hour, Minute, Second);
			double NewUnixTime = ConvertToUnixTimestamp(NewDateTime);
			Congratulation tempVar = new Congratulation();
			tempVar.setDescription(AddDescription);
			tempVar.setUnixTime(NewUnixTime);
			this.ListOfCongratulations.add(tempVar);
			this.AddedUnixTime = NewUnixTime;
		}
		else
		{
			System.out.println("TimeStamp Input Error: Invalid Minutes!");
		}
	}


	public final void EditD6()
	{
		System.out.print("New Seconds: ");
		Input = new Scanner(System.in).nextLine();
	Second = tryParseInt(Input);
		if (!RES)
		{
			System.out.println("Input Error: Use only 0...9 symbols");
		}
		else if ((Second >= 0) && (Second <= 59))
		{
			if (!this.ListOfCongratulations.isEmpty())
			{
				this.ListOfCongratulations.remove(Selected);
			}

			LocalDateTime NewDateTime = LocalDateTime.of(Year, Month, Day, Hour, Minute, Second);
			double NewUnixTime = ConvertToUnixTimestamp(NewDateTime);
			Congratulation tempVar = new Congratulation();
			tempVar.setDescription(AddDescription);
			tempVar.setUnixTime(NewUnixTime);
			this.ListOfCongratulations.add(tempVar);
			this.AddedUnixTime = NewUnixTime;
		}
		else
		{
			System.out.println("TimeStamp Input Error: Invalid Seconds!");
		}

	}


	public final void Remove() throws IOException {
		if (!this.ListOfCongratulations.isEmpty())
		{
			//Runtime.getRuntime().exec("cls");
			this.ListOfCongratulations.remove(Selected);
			System.out.println("Succesfully removed!");
		}
		else
		{
			//Runtime.getRuntime().exec("cls");
			System.out.println("Nothing to remove!");
		}


		System.out.println();
		System.out.println("Press ANY key to Continue!");
		int num = 0;
		do
		{
			int cki = System.in.read();;
			if (cki != 0)
			{
				break;
			}

		} while (true);

	}


	public final void Show()
	{
		System.out.println("My List of congatulations:");
		System.out.println();

		//Collections.sort(this.ListOfCongratulations, CompareUnixTime);

		if (this.ListOfCongratulations.size() == 1)
		{
			this.Selected = 0;
		}

		if (this.AddedUnixTime > 0)
		{
			for (int i = 0; i < this.ListOfCongratulations.size(); i++)
			{
				if (this.AddedUnixTime == this.ListOfCongratulations.get(i).getUnixTime())
				{
					this.Selected = i;
				}
			}

			this.AddedUnixTime = 0;
		}




		for (int i = 0; i < this.ListOfCongratulations.size(); i++)
		{
			if (i == Selected)
			{
				long unixSeconds = (long)ListOfCongratulations.get(i).getUnixTime();
// convert seconds to milliseconds
				Date date = new java.util.Date(unixSeconds*1000L);
// the format of your date
				SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
// give a timezone reference for formatting (see comment at the bottom)
				sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT-4"));
				String formattedDate = sdf.format(date);
				System.out.println(ANSI_RED + formattedDate + " " + this.ListOfCongratulations.get(i).getDescription() + ANSI_RESET);
			}
			else
			{
				//Console.BackgroundColor = ConsoleColor.Black;
				//Console.ForegroundColor = ConsoleColor.White;

				long unixSeconds = (long)ListOfCongratulations.get(i).getUnixTime();
// convert seconds to milliseconds
				Date date = new java.util.Date(unixSeconds*1000L);
// the format of your date
				SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
// give a timezone reference for formatting (see comment at the bottom)
				sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT-4"));
				String formattedDate = sdf.format(date);

				System.out.println(formattedDate + " " + this.ListOfCongratulations.get(i).getDescription());
			}
			//Console.BackgroundColor = ConsoleColor.Black;
			//Console.ForegroundColor = ConsoleColor.White;
		}

		//foreach (Congratulation plan in ListOfCongratulations)
		//Console.WriteLine(ConvertFromUnixTimestamp(plan.UnixTime).ToString("yyyy/MM/dd HH:mm:ss") + " " + plan.Description);

	}
}