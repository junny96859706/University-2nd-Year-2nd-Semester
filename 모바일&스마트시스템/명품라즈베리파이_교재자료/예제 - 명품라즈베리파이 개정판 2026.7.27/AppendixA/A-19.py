def gugudan(n):
	for i in range(1,10):
		print("%d x %d = %d" % (n, i, n*i))

a = input("구구단 몇단을 원하세요>> ")
n = int(a)
gugudan(n)

