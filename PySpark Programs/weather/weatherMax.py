import sys
if(len(sys.argv)!=3):
	print("Provide Input File and Output Directory")
	sys.exit(0)
from pyspark import SparkContext
sc =SparkContext()
f = sc.textFile(sys.argv[1])
temp=f.map(lambda x:(int(x[15:19]),int(float(x[87:92]))))

maxi=temp.reduceByKey(lambda a,b:a if a>b else b)
maxi.saveAsTextFile(sys.argv[2])
