// import java.io.*;

// class Round_robin {
//     public static void main(String args[]) throws IOException {
//         DataInputStream in = new DataInputStream(System.in);
//         int i, j, k, q, sum = 0;
//         System.out.println("Enter number of process:");
//         int n = Integer.parseInt(in.readLine());
//         int bt[] = new int[n];
//         int wt[] = new int[n];
//         int tat[] = new int[n];
//         int a[] = new int[n];
//         System.out.println("Enter brust Time:");
//         for (i = 0; i < n; i++) {
//             System.out.println("Enter brust Time for " + (i + 1));
//             bt[i] = Integer.parseInt(in.readLine());
//         }
//         System.out.println("Enter Time quantum:");
//         q = Integer.parseInt(in.readLine());
//         for (i = 0; i < n; i++)
//             a[i] = bt[i];
//         for (i = 0; i < n; i++)
//             wt[i] = 0;
//         do {
//             for (i = 0; i < n; i++) {
//                 if (bt[i] > q) {
//                     bt[i] -= q;
//                     for (j = 0; j < n; j++) {
//                         if ((j != i) && (bt[j] != 0))
//                             wt[j] += q;
//                     }
//                 } else {
//                     for (j = 0; j < n; j++) {
//                         if ((j != i) && (bt[j] != 0))
//                             wt[j] += bt[i];
//                     }
//                     bt[i] = 0;
//                 }
//             }
//             sum = 0;
//             for (k = 0; k < n; k++)
//                 sum = sum + bt[k];
//         } while (sum != 0);
//         for (i = 0; i < n; i++)
//             tat[i] = wt[i] + a[i];
//         System.out.println("process\t\tBT\tWT\tTAT");
//         for (i = 0; i < n; i++) {
//             System.out.println("process" + (i + 1) + "\t" + a[i] + "\t" + wt[i] + "\t" + tat[i]);
//         }
//         float avg_wt = 0;
//         float avg_tat = 0;
//         for (j = 0; j < n; j++) {
//             avg_wt += wt[j];
//         }
//         for (j = 0; j < n; j++) {
//             avg_tat += tat[j];
//         }
//         System.out.println("average waiting time " + (avg_wt / n) + "\n Average turn around time" + (avg_tat / n));
//     }
// }

import java.util.Scanner;

public class Round_robin {
    public static void main(String args[]) {
        int n, i, qt, count = 0, temp, sq = 0, bt[], wt[], tat[], rem_bt[];
        float awt = 0, atat = 0;
        bt = new int[10];
        wt = new int[10];
        tat = new int[10];
        rem_bt = new int[10];
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of process (maximum 10) = ");
        n = s.nextInt();
        System.out.print("Enter the burst time of the process\n");
        for (i = 0; i < n; i++) {
            System.out.print("P" + i + " = ");
            bt[i] = s.nextInt();
            rem_bt[i] = bt[i];
        }
        System.out.print("Enter the quantum time: ");
        qt = s.nextInt();
        while (true) {
            for (i = 0, count = 0; i < n; i++) {
                temp = qt;
                if (rem_bt[i] == 0) {
                    count++;
                    continue;
                }
                if (rem_bt[i] > qt)
                    rem_bt[i] = rem_bt[i] - qt;
                else if (rem_bt[i] >= 0) {
                    temp = rem_bt[i];
                    rem_bt[i] = 0;
                }
                sq = sq + temp;
                tat[i] = sq;
            }
            if (n == count)
                break;
        }
        System.out.print("--------------------------------------------------------------------------------");
        System.out.print("\nProcess\t      Burst Time\t       Turnaround Time\t          Waiting Time\n");
        System.out.print("--------------------------------------------------------------------------------");
        for (i = 0; i < n; i++) {
            wt[i] = tat[i] - bt[i];
            awt = awt + wt[i];
            atat = atat + tat[i];
            System.out.print("\n " + (i + 1) + "\t " + bt[i] + "\t\t " + tat[i] + "\t\t " + wt[i] + "\n");
        }
        awt = awt / n;
        atat = atat / n;
        System.out.println("\nAverage waiting Time = " + awt + "\n");
        System.out.println("Average turnaround time = " + atat);
    }
}