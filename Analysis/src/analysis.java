/*Conway's Game of Life*/
//Instructions to get next generations
/* 1. Cell will be alive only when it has 2 or 3 neighbours
* 2. Cell will be dead when it has less than 2 neighbours due to isolation
* 3. Cell will be dead when it has more than 3 neighbours due to over-population * 4.
Cell will be reproduced when it has exactly 3 neighbours
*/
import java.util.Scanner;
import java.util.Random;
//import java.util*;
public class analysis {
public static void main(String[] args)
{ boolean play =
true; while(play) {
int M, N;
Scanner sc = new Scanner(System.in);
System.out.println("WELCOME TO CONWAY'S GAME OF LIFE\nThe game is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input.\nOne interacts with the Game of Life by creating an initial configuration and observing how it evolves.");
System.out.println("Rules to play the game to generate next generations");
System.out.println(" 1. Cell will be alive only when it has 2 or 3 neighbours\n 2. Cell willbe dead when it has less than 2 neighbours due to isolation\n 3. Cell will be dead when it has more than 3 neighbours due to over-population\n 4. Cell will be reproduced when it has exactly 3 neighbours");
System.out.print("\nEnter the no. of rows: ");
M = sc.nextInt();
M = M+2;
System.out.print("\nEnter the no.of columns: ");
N = sc.nextInt(); N = N+2;
int i,j;

//4

int grid[][]= new int[M][N];
for(i = 0;i<M;i++) {
for(j = 0;j<N;j++) {
grid[i][j] = 0;
}
}
for (i = 1; i < M-1; i++)
{
for (j = 1; j < N-1; j++)
{
if(Math.random()>0.5) {
grid[i][j] = 1;
}
}
}
nextGeneration(grid, M, N,0);
System.out.println("GAME OVER");
System.out.println();
System.out.println("Press 1 to play again or any other number to quit playing");
int s; s=sc.nextInt(); if(s != 1)
{
play=false;
}
}
}
//Function to print next generation
static void nextGeneration(int grid[][], int M, int N, int count)
{
int[][] future = new int[M][N];
System.out.println("\nGeneration "+ count);
for (int i = 1; i < M-1; i++)
{
for (int j = 1; j < N-1; j++)
{
if (grid[i][j] == 0)
System.out.print("0 "); else
System.out.print("1 ");
}
System.out.println();
}
//Loop through every cell

//5

for (int l = 1; l < M - 1; l++)
{
for (int m = 1; m < N - 1; m++)
{
//finding no Of Neighbours that are alive
int aliveNeighbours = 0; for (int i = -1; i
<= 1; i++) for (int j = -1; j <= 1; j++)
aliveNeighbours += grid[l + i][m + j];
//The cell needs to be subtracted from
//its neighbours as it was counted before
aliveNeighbours -= grid[l][m];
//Implementing the Rules of Life
//Cell is lonely and dies
if ((grid[l][m] == 1) && (aliveNeighbours < 2))
future[l][m] = 0;
//Cell dies due to over population
else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
future[l][m] = 0;
//A new cell is born
else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
future[l][m] = 1;
//Remains the same
else
future[l][m] = grid[l][m];
}
}
Scanner sc = new Scanner(System.in);
System.out.println("Press 5 for Next generation\nPress 4 to exit");
int d = sc.nextInt(); if(d == 5) { int isSame = 0; for(int
i=1;i<M-1;i++) { for(int j=1;j<N-1;j++) {
if(future[i][j]!=grid[i][j]) { isSame = 1;
}
}
}
if(isSame == 1) {
nextGeneration(future, M, N,count+1);
}

//6

}
}
}