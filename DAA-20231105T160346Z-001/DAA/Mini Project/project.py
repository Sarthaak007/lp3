# Python3 Program to multiply two matrix using multi-threading
from threading import Thread

MAX = 4
MAX_THREAD = 4

matC = [[0 for i in range(MAX)] for j in range(MAX)]
step_i = 0

# Function to print matrix in readable format
def printMatrix(mat):
for row in mat:
	print(row)

# Function to multiply a row of matrix A
# with entire matrix B to get a row of matrix C
def multi():
global step_i, matC
i = step_i
step_i = step_i + 1
for j in range(MAX):
	for k in range(MAX):
	matC[i][j] = matC[i][j] + matA[i][k] * matB[k][j]

if __name__ == "__main__":
# matrix A used for muliplication
matA = [[3,7,3,6],
		[9,2,0,3],
		[0,2,1,7],
		[2,2,7,9]]

# matrix B used for multiplication
matB = [[6,5,5,2],
		[1,7,9,6],
		[6,6,8,9],
		[0,3,5,2]]
# creating list of size MAX_THREAD
thread = list(range(MAX_THREAD))
# creating MAX_THEAD number of threads
for i in range(MAX_THREAD):
	thread[i] = Thread(target=multi)
	thread[i].start()
	
# Waiting for all threads to finish
for i in range(MAX_THREAD):
	thread[i].join()
	
# Printing the resultant matrix C = A x B
printMatrix(matC)
