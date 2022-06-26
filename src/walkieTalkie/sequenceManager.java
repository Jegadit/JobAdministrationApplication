package walkieTalkie;

import java.util.*;


class SequenceManager extends Profit{
	static int[] V = WorkerJobAllocate.Akhilgetjob();
			
void optimum_sequence_jobs(double P)
{
	int j = 1, N = V.length - 1;
	double result = 0;

	PriorityQueue<Integer> Queue =
				new PriorityQueue<>();

	for (int i = 1; i <= N; i++)
	Queue.add(V[i]);

	System.out.println("The optimal sequence to reduce loss is : ");
	while (!Queue.isEmpty())
	{
	System.out.print(Queue.peek() +" ");

	V[j++] = Queue.peek();
	Queue.remove();
	}

	for (int i = N; i >= 1; i--)
	result += Math.pow((1 - P),N - i) * V[i];

	System.out.printf("\nProfit : %.2f units\n",result );
}
}

