///////////////////////////////////////////////////////////////////
//
//
//	Customised DataBase Management System
//
//
///////////////////////////////////////////////////////////////////

import java.lang.*;
import java.util.*;

class Employee
{
    public int ID;
    public String Name;
    public int Salary;

    private static int Generator;
    static
    {
        Generator = 0;
    }

    public Employee(String str, int value)
    {
        this.ID = ++Generator;
        this.Name = str;
        this.Salary = value;
    }

    public void DisplayData()
    {
        System.out.println("\t|\t"+this.ID+"\t|\t\t"+this.Name+"\t\t|\t\t"+this.Salary+"\t\t|");
        System.out.println("        ---------------------------------------------------------------------------------");
    }
}

class DBMS
{
    public LinkedList<Employee>lobj;

    public DBMS()
    {
        lobj = new LinkedList<>();
    }

    public void StartDBMS()
    {
        Scanner scanobj = new Scanner(System.in);

        System.out.println("Pratik's Customized DBMS started successfully...");
        String Query = "";
        while(true)
        {
            System.out.print("Pratik's DBMS console > ");
            Query = scanobj.nextLine();

            String tokens[] = Query.split(" ");
            int QuerySize = tokens.length;

            if(QuerySize == 1)
            {
                if("Help".equals(tokens[0]))
                {
                    System.out.println("\nThis application is used to demonstrates the customized DBMS\n");

                    System.out.println("Description  : Insert new Record :");
                    System.out.println("Query  : Insert into Employee Name Salary\n");
                    System.out.println("Description  : Display All Record :");
                    System.out.println("Query  : Select * from  Employee\n");
                    System.out.println("Description  : Select Specific Record using ID :");
                    System.out.println("Query  : Select * from Employee where ID = Employee_ID\n");
                    System.out.println("Description  : Select Specific Record using Name :");
                    System.out.println("Query  : Select * from Employee where Name = Employee_Name\n");
                    System.out.println("Description  : Select Specific Record using Salary :");
                    System.out.println("Query  : Select * from Employee where Salary = Employee_Salary\n");
                    System.out.println("Description  : Delete specific Record using ID :");
                    System.out.println("Query  : Delete from Employee where ID = Employee_ID\n");
                    System.out.println("Description  : Delete specific Record using Name :");
                    System.out.println("Query  : Delete from Employee where Name = Employee_Name\n");
                    System.out.println("Description  : Display Maximum Salary :");
                    System.out.println("Query  : Select Max Salary\n");
                    System.out.println("Description  : Display Minimum Salary :");
                    System.out.println("Query  : Select Min Salary\n");
                    System.out.println("Description  : Display Sum of Salary :");
                    System.out.println("Query  : Select Sum Salary\n");
                    System.out.println("Description  : Display Average of  Salary :");
                    System.out.println("Query  : Select Avg Salary\n");
                    System.out.println("Description  : Display Count of  Records :");
                    System.out.println("Query  : Select Count Salary\n");
                    System.out.println("exit   : Terminate DBMS\n");
                }
                else if("exit".equals(tokens[0]))
                {
                    System.out.println("Thank you for using Pratik's DBMS");
                    break;
                }
                else
                {
                    System.out.println("ERROR : Invalid Query ");
                }
            }
            if(QuerySize == 2)
            {
					
                  System.out.println("ERROR : Invalid Query ");
            }

            if(QuerySize == 3)
            {
                // Select count Salary
                if("Select".equals(tokens[0]))
                {
                    if("Count".equals(tokens[1]))
                    {
                        if("Salary".equals(tokens[2]))
                        {
                                 AggregateCount();
                        }
                        else
                        {
                            System.out.println("ERROR : Invalid Query ");
                        }
                        
                    }
                    else if("Max".equals(tokens[1]))
                    {
                        //Select Max Salary
                        if("Salary".equals(tokens[2]))
                        {
                            AggregateMax();
                        }
                    }
                    else if("Min".equals(tokens[1]))
                    {
                        //Select Min Salary
                        if("Salary".equals(tokens[2]))
                        {
                            AggregateMin();
                        }
                    }
                    else if("Sum".equals(tokens[1]))
                    {
                        //Select Sum Salary
                        if("Salary".equals(tokens[2]))
                        {
                            AggregateSum();
                        }
                    }
                    else if("Avg".equals(tokens[1]))
                    {
                        // Select Avg Salary
                        if("Salary".equals(tokens[2]))
                        {
                              AggregateAvg();
                        }
                        else
                        {
                            System.out.println("ERROR : Invalid Query ");
                        }
                    }
                    else
                    { 
                        System.out.println("ERROR : Invalid Query ");
                    }
                }
                else
                {
                    System.out.println("ERROR : Invalid Query ");
                }
            }

            if(QuerySize == 4)
            {
                //Select * from  Employee
                if("Select".equals(tokens[0]))
                {
                    if("*".equals(tokens[1]))
                    {
                        if("from".equals(tokens[2]))
                        {
                            if("Employee".equals(tokens[3]))
                            {   
                                DisplayAll();
                            }
                            else
                            {
                                System.out.println("ERROR : Invalid Query ");
                            }
                        }
                        else
                        {
                            System.out.println("ERROR : Invalid Query ");
                        }
                    }
                    else
                    {
                        System.out.println("ERROR : Invalid Query ");
                    }
                }
                else
                {
                    System.out.println("ERROR : Invalid Query ");
                }
            }
            if(QuerySize == 5)
            {
                //Insert into Employee
                if("Insert".equals(tokens[0]))
                {
                    if("into".equals(tokens[1]))
                    {
                        if("Employee".equals(tokens[2]))
                        {
                            InsertData(tokens[3], Integer.parseInt(tokens[4]));
                        }
                        else
                        {
                           System.out.println("ERROR : Invalid Query ");
                        }
                    }
                    else
                    {
                        System.out.println("ERROR : Invalid Query ");
                    }
                }
                else
                {
                    System.out.println("ERROR : Invalid Query ");
                }
            }

            if(QuerySize == 6)
            {
                System.out.println("ERROR : Invalid Query ");  
            }

            if(QuerySize == 7)
            {
                //Delete from Employee where Name = Employee_Name
                if("Delete".equals(tokens[0]))
                {
                    if("from".equals(tokens[1]))
                    {
                        if("Employee".equals(tokens[2]))
                        {
                            if("where".equals(tokens[3]))
                            {
                                if("Name".equals(tokens[4]))
                                {
                                    if("=".equals(tokens[5]))
                                    {
                                        DeleteSpecific(tokens[6]);
                                    }
                                    else
                                    {
                                        System.out.println("ERROR : Invalid Query ");
                                    }
                                }
                                else if("ID".equals(tokens[4]))
                                {
                                    //Delete from Employee where ID = Employee_ID
                                    if("=".equals(tokens[5]))
                                    {
                                        DeleteSpecific(Integer.parseInt(tokens[6]));
                                    }
                                    else
                                    {
                                        System.out.println("ERROR : Invalid Query ");
                                    }
                                }
                                else
                                {
                                    System.out.println("ERROR : Invalid Query ");
                                }
                            }
                            else
                            {
                               System.out.println("ERROR : Invalid Query ");
                            }
                        }
                        else
                        {
                            System.out.println("ERROR : Invalid Query ");
                        }
                    }
                    else
                    {
                        System.out.println("ERROR : Invalid Query ");
                    }
                }
                else
                {
                    System.out.println("ERROR : Invalid Query ");
                }
            }

            if(QuerySize == 8)
            {
                // Select Specific Record using ID 
                if("Select".equals(tokens[0]))
                {
                    if("*".equals(tokens[1]))
                    {
                        if("from".equals(tokens[2]))
                        {
                            if("Employee".equals(tokens[3]))
                            {   
                                if("where".equals(tokens[4]))
                                {
                                    if("ID".equals(tokens[5]))
                                    {
                                        if("=".equals(tokens[6]))
                                        {
                                            DisplaySpecific(Integer.parseInt(tokens[7]));
                                        }
                                        else
                                        {
                                            System.out.println("ERROR : Invalid Query ");
                                        }
                                    }
                                    else if("Name".equals(tokens[5]))
                                    {
                                        //Select Specific Record using Name 
                                        if("=".equals(tokens[6]))
                                        {
                                            DisplaySpecific(tokens[7]);
                                        }
                                        else
                                        {
                                            System.out.println("ERROR : Invalid Query ");
                                        }
                                    }
                                    else if("Salary".equals(tokens[5]))
                                    {
                                        //Select * from Employee where Salary = Employee_Salary
                                        if("=".equals(tokens[6]))
                                        {
                                            DisplaySpecificX(Integer.parseInt(tokens[7]));
                                        }
                                        else
                                        {
                                           System.out.println("ERROR : Invalid Query ");
                                        }
                                    }
                                    else
                                    {
                                          System.out.println("ERROR : Invalid Query "); 
                                    }
                                }
                                else
                                {
                                    System.out.println("ERROR : Invalid Query ");
                                }
                            }
                            else
                            {
                                System.out.println("ERROR : Invalid Query ");
                            }
                        }
                        else
                        {
                            System.out.println("ERROR : Invalid Query ");
                        }
                    }
                    else
                    {
                        System.out.println("ERROR : Invalid Query ");
                    }
                }
                else
                {
                   System.out.println("ERROR : Invalid Query ");
                }
            }
        }
    }


    public void InsertData(String str, int value)
    {
        Employee sobj = new Employee(str, value);
        lobj.add(sobj);
    }

     //Display all without condition
    public void DisplayAll()
    {
        System.out.println("        ---------------------------------------------------------------------------------");
        System.out.println("\t|\tID\t|\t\tName\t\t|\t\tSalary\t\t|");
        System.out.println("        ---------------------------------------------------------------------------------");
        for(Employee sref : lobj)
        {
            sref.DisplayData();
        }
    }
   
    public void DisplaySpecific(int ID)
    {
        System.out.println("        ---------------------------------------------------------------------------------");
        System.out.println("\t|\tID\t|\t\tName\t\t|\t\tSalary\t\t|");
         System.out.println("        ---------------------------------------------------------------------------------"); 
        for(Employee sref : lobj)
        {
            if(sref.ID == ID)
            {
                sref.DisplayData();
                break;
            }
        }
    }

    public void DisplaySpecific(String str)
    {
        System.out.println("        ---------------------------------------------------------------------------------");
        System.out.println("\t|\tID\t|\t\tName\t\t|\t\tSalary\t\t|");
         System.out.println("        ---------------------------------------------------------------------------------");
        for(Employee sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                sref.DisplayData();
            }
        }
    }

    public void DisplaySpecificX(int salary)
    {
        System.out.println("        ---------------------------------------------------------------------------------");
        System.out.println("\t|\tID\t|\t\tName\t\t|\t\tSalary\t\t|");
         System.out.println("        ---------------------------------------------------------------------------------");
        for(Employee sref : lobj)
        {
            if(sref.Salary == salary)
            {
                sref.DisplayData();
            }
        }
    }

    public void DeleteSpecific(int ID)
    {
       
        int index = 0;
        for(Employee sref : lobj)
        {
            if(sref.ID == ID)
            {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }

    public void DeleteSpecific(String str)
    {
        int index = 0;
        for(Employee sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }
     
     // Display by Maximum Salary
    public void AggregateMax()
    {
        int iMax = 0;
        Employee temp = null;

        for(Employee sref : lobj)
        {
            if(sref.Salary > iMax)
            {
                iMax = sref.Salary;
                temp = sref;
            }
        }
        
        System.out.println("Information of Employee having maximum salary : ");
         System.out.println("        ---------------------------------------------------------------------------------");
        System.out.println("\t|\tID\t|\t\tName\t\t|\t\tSalary\t\t|");
         System.out.println("        ---------------------------------------------------------------------------------");
        temp.DisplayData();
    }

    public void AggregateMin()
    {
        int iMin = (lobj.getFirst()).Salary;
        Employee temp = lobj.getFirst();

        for(Employee sref : lobj)
        {
            if(sref.Salary < iMin)
            {
                iMin = sref.Salary;
                temp = sref;
            }
        }
        System.out.println("Information of Employee having minimum salary : ");
        System.out.println("        ---------------------------------------------------------------------------------");
        System.out.println("\t|\tID\t|\t\tName\t\t|\t\tSalary\t\t|");
        System.out.println("        ---------------------------------------------------------------------------------");
        temp.DisplayData();
    }

    public void AggregateSum()
    {
        long iSum = 0;

        for(Employee sref : lobj)
        {
            iSum = iSum + sref.Salary;
        }
        System.out.println("Summation of salaries is : "+iSum);
    }

    public void AggregateAvg()
    {
        long iSum = 0;

        for(Employee sref : lobj)
        {
            iSum = iSum + sref.Salary;
        }
        System.out.println("Average salary is : "+iSum/(lobj.size()));
    }

    public void AggregateCount()
    {
        System.out.println("Count is : "+lobj.size());
    }  

}

class CDBMS
{
    public static void main(String arg[])
    {
        DBMS dobj = new DBMS();

        dobj.StartDBMS();
    }
}