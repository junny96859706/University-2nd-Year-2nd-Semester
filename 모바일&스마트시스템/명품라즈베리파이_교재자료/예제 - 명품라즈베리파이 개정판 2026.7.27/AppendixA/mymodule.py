delta = 10 # 전역변수. 모듈의 프로퍼티

def plus(value):
	global delta # 전역변수 delta
	delta += value
	return delta

if __name__ == '__main__' :
	print("mymodule 테스트 %d" % plus(100))

if __name__ == 'mymodule' :
	print("mymodule imported...\n delta is initialized to 10\n")

