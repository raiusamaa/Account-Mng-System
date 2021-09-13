import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class utility {

    bank[] B=new bank[100];

    void main2()
    {
        checking CH;
        saving S = null;
        int check=1,choice1,choice2=0,d0,d1,d3,d4=1,d5,d6,d7,counter=0;
        String s1,s2,s3,s4,s5,s6,s7,s8;
        long ac;
        s3="Heart To Heart";
        s4="MH Ali";
        s5="G11-Markaz, Islamabad";
        d0=51987722;
        s7="Saving";
        s8="Checking";
        Scanner input=new Scanner(System.in);
        while (check==1)
        {
            System.out.println("\n     Welcome to Heart To Heart Bank\n");
            System.out.println("Press 1 to Open a New Account\n");
            System.out.println("Press 2 to Login by Account Number\n");
            System.out.println("Press 3 to Exit from system\n");
            choice1=input.nextInt();
            if (choice1==1)
            {
                System.out.println("Enter Your name");
                s1=input.next();
                System.out.println("Enter Your address");
                s2=input.next();
                System.out.println("Enter Your Number");
                d1=input.nextInt();
                System.out.println("Which Type of Account you want to Open\n Press " +
                        "1 for Saving Account \n Press 2 for Checking Account\n");
                choice2=input.nextInt();
                System.out.println("Account Number allocated");
                ac=input.nextLong();
                System.out.println("Enter Amount you want to deposit");
                d3=input.nextInt();
                if (choice2==1)
                {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date();
                    s6=formatter.format(date);
                    S=new saving (s3,s4,s5,d0,s1,s2,d1,s7,ac,d3,s6);
                    B[counter]=S;
                    counter++;
                    System.out.println(s6);
                }
                else
                {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date();
                    s6=formatter.format(date);
                    CH=new checking (s3,s4,s5,d0,s1,s2,d1,s8,ac,d3,s6);
                    B[counter]=CH;
                    counter++;
                }
            }
            else if (choice1==2)
            {
                System.out.println("Enter Account Number to Login\n");
                d1=input.nextInt();
                for (int i=0;i<counter;i++)
                {
                    if (B[i].accN()==d1)
                    {
                        System.out.println("Name of account holder is " + B[i].cname());
                        System.out.println("Adress of account holder is " + B[i].caddress());
                        System.out.println("Phone Number of account holder is " + B[i].number());
                        System.out.println("Account Number of account holder is " + B[i].accN());
                        System.out.println("Amount in Account is " + B[i].amount());
                        System.out.println("Account was created on " + B[i].datee());
                        System.out.println("Press 1 to perform operations and 2 to exit");
                        d5 = input.nextInt();
                        if (d5 == 1)
                        {
                            while (d4 == 1)
                            {
                                System.out.println("Press 1 to deposit money in your account");
                                System.out.println("Press 2 to withdraw money from your account");
                                System.out.println("Press 3 to check money in your account");
                                System.out.println("Press 4 to transfer money from your account");
                                System.out.println("Press 5 to calculate Zakaat of your account");
                                System.out.println("Press 6 to calculate Interest of your account");
                                System.out.println("Press 7 to display Details of your account");
                                System.out.println("Press 8 to Exit");
                                d1 = input.nextInt();
                                if (d1 == 1)
                                {
                                    System.out.println("Enter amount");
                                    d6 = input.nextInt();
                                    makeDeposit(B[i].accN(), d6, counter);
                                }
                                else if (d1 == 2)
                                {
                                    System.out.println("Enter amount");
                                    d6 = input.nextInt();
                                    if (B[i].amount() >= d6)
                                    {
                                        withDraw(B[i].accN(), d6, counter);
                                    }
                                    else
                                    {
                                        System.out.println("Insufficient Balance");
                                    }
                                }
                                else if (d1 == 3)
                                {
                                    checkBalance(B[i].accN(), counter);
                                }
                                else if (d1 == 4)
                                {
                                    long a1;
                                    System.out.println("Enter Receiver's account Number");
                                    a1 = input.nextLong();
                                    System.out.println("Enter Amount");
                                    d7 = input.nextInt();
                                    transferMoney(B[i].accN(), a1, d7, counter);
                                }
                                else if (d1 == 5)
                                {
                                    if (B[i].type() == "Saving")
                                    {
                                        S.calculateZakkat(B[i].amount());
                                    }
                                    else
                                    {
                                        System.out.println("Zakaat doesn't applied on your Account Type");
                                    }
                                }
                                else if (d1 == 6)
                                {
                                    if (B[i].type() == "Saving")
                                    {
                                        S.calculateInterest(B[i].amount(), 10);
                                    }
                                    else
                                    {
                                        System.out.println("Zakaat doesn't applied on your Account Type");
                                    }
                                }
                                else if (d1 == 7)
                                {
                                    displayDetails(B[i].accN(),counter);
                                }
                                else if (d1==8)
                                {
                                    d4=0;
                                    check=0;
                                    System.out.println("Thank You for using Our Services ");
                                }
                            }
                        }
                        else
                        {
                            check=0;
                            System.out.println("Thank You for using Our Services ");
                        }
                    }
                }
            }
            else if (choice1==3)
            {
                System.out.println("Thank You for using Our Services ");
                check=0;
            }
            else
            {
                System.out.println("Wrong CHOICE, Try Again !!");
            }
        }
    }

    void makeDeposit (long a,int am,int c)
    {
        for (int i=0;i<c;i++)
        {
            if (B[i].accN()==a)
            {
                B[i].setAmount(B[i].amount()+am);
            }
        }
    }
    void transferMoney(long a, long b, int am, int c)
    {
        int temp,temp2=0,temp3=0;
        boolean flag=false,flag1=false;
        for (int i=0;i<c;i++)
        {
            if (B[i].accN()==a)
            {
                if (B[i].amount()>=am)
                {
                    temp=am;
                    B[i].setAmount(B[i].amount()-am);
                    flag=true;
                }
                temp3=i;
            }
        }
        for (int i=0;i<c;i++)
        {
            if (B[i].accN()==b)
            {
                temp2=i;
                flag1=true;
                break;
            }
        }
        if (flag1==true && flag==true)
        {
            B[temp2].setAmount(B[0].amount()+am);
            System.out.println("Amnount Transfered Successfully\n");
        }
        else
        {
            B[temp3].setAmount(B[temp3].amount()+am);
            System.out.println("Receiver's Account Doesn't exists\n ");
        }
    }
    void withDraw(long acc,int amount,int c)
    {
        for (int i=0;i<c;i++)
        {
            if (B[i].accN()==acc)
            {
                if (B[i].amount()>=amount)
                {
                    B[i].setAmount(B[i].amount() - amount);
                    System.out.println("Amount Withdrawn Successfully\n");
                    System.out.println("Remaining Amount is " + B[i].amount());
                }
                else
                {
                    System.out.println("Not Enough Balance !!");
                }
            }
        }
    }
    void checkBalance(long acc,int c)
    {
        for (int i=0;i<c;i++)
        {
            if (B[i].accN()==acc)
            {
                System.out.println("Your Balance is " + B[i].amount() + "\n");
            }
        }
    }
    void displayDetails(long acc,int c)
    {
        for (int i=0;i<c;i++)
        {
            if (B[i].accN()==acc)
            {
                System.out.println("Name of account holder is "+B[i].cname()+"\n");
                System.out.println("Adress of account holder is "+B[i].caddress()+"\n");
                System.out.println("Phone Number of account holder is "+ B[i].number()+"\n");
                System.out.println("Account Number of account holder is "+B[i].accN()+"\n");
                System.out.println("Amount in Account is "+B[i].amount()+"\n");
                System.out.println("Bank Owner is "+B[i].oname+"\n");
                System.out.println("Bank Name is "+B[i].bname+"\n");
                System.out.println("Adrress of Bank is "+ B[i].address);
                System.out.println("Phone Number of Bank is "+B[i].number());
            }
        }
    }
}
