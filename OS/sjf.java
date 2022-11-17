import java.util.Scanner;

public class sjf {
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter no of process:");
        int n= sc.nextInt();
        int pid[]=new int[n];
        int at[]=new int[n];
        int bt[]=new int[n];
        int ct[]=new int[n];
        int tat[]=new int[n];
        int wt[]=new int[n];
        int f[]=new int[n];

        int st=0, tot=0;
        float avgwt=0, avgtat=0;

        for(int i=0;i<n;i++)
        {
            System.out.println("enter process "+(i+1)+"arrival time: ");
            at[i]=sc.nextInt();
            System.out.println("enter process "+(i+1)+"burst time time: ");
            bt[i]=sc.nextInt();
            pid[i]=i+1;
            f[i]=0;
        }
        while(true)
        {
            int c=n,min=999;
            if(tot==n)
            break;
            for (int i=0;i<n;i++)
            {
                if((at[i]<=st) && (f[i]==0) &&(bt[i]<min))
                {
                    min=bt[i];
                    c=i;
                }
            }
            if (c==n)
            st++;
            else{
                ct[c]=st+bt[c];
                st+=bt[c];
                tat[c]=ct[c]-at[c];
                wt[c]=tat[c]-bt[c];
                f[c]=1;
                pid[tot]=c+1;
                tot++;
            }
        }

        System.out.println("\npid arrival burst completion turn waiting ");
        for(int i=0;i<n;i++)
        {
            avgwt+=wt[i];
            avgtat+=tat[i];
            System.out.println(pid[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]);
        }
        System.out.println("\n average turn around time is"+(float)(avgtat/n));
        System.out.println("\n average waiting time is"+(float)(avgwt/n));
        sc.close();
        for (int i=0;i<n;i++)
        {
            System.out.println(pid[i] + " ");
        }
        


    }
}

------------------------------------------------------------------------------------------------------------------------------------------------
    
    Preemptive :

Program :

import java.util.*;
 
public class Main {
public static void main (String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println ("enter no of process:");
int n= sc.nextInt();
int pid[] = new int[n]; // it takes pid of process
int at[] = new int[n]; // at means arrival time
int bt[] = new int[n]; // bt means burst time
int ct[] = new int[n]; // ct means complete time
int ta[] = new int[n];// ta means turn around time
int wt[] = new int[n];  // wt means waiting time
int f[] = new int[n];  // f means it is flag it checks process is completed or not
int k[]= new int[n];   // it is also stores brust time
    int i, st=0, tot=0;
    float avgwt=0, avgta=0;
 
    for (i=0;i<n;i++)
    {
     pid[i]= i+1;
     System.out.println ("enter process " +(i+1)+ " arrival time:");
     at[i]= sc.nextInt();
     System.out.println("enter process " +(i+1)+ " burst time:");
     bt[i]= sc.nextInt();
     k[i]= bt[i];
     f[i]= 0;
    }
    
    while(true){
     int min=99,c=n;
     if (tot==n)
     break;
    
     for ( i=0;i<n;i++)
     {
     if ((at[i]<=st) && (f[i]==0) && (bt[i]<min))
     {
     min=bt[i];
     c=i;
     }
     }
    
     if (c==n)
     st++;
     else
     {
     bt[c]--;
     st++;
     if (bt[c]==0)
     {
     ct[c]= st;
     f[c]=1;
     tot++;
     }
     }
    }
    
    for(i=0;i<n;i++)
    {
     ta[i] = ct[i] - at[i];
     wt[i] = ta[i] - k[i];
     avgwt+= wt[i];
     avgta+= ta[i];
    }
    
    System.out.println("pid  arrival  burst  complete turn waiting");
    for(i=0;i<n;i++)
    {
     System.out.println(pid[i] +"\t"+ at[i]+"\t"+ k[i] +"\t"+ ct[i] +"\t"+ ta[i] +"\t"+ wt[i]);
    }
    
    System.out.println("\naverage tat is "+ (float)(avgta/n));
    System.out.println("average wt is "+ (float)(avgwt/n));
    sc.close();
}
}
