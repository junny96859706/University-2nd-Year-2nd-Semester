def insert():
	name = input("이름을 입력하세요: ")
	phone = input("전화번호를 입력하세요: ")

	phone_book[name] = phone

def remove():
	name = input("이름을 입력하세요: ")
	if(phone_book.get(name) is not None):
		del phone_book[name]
	pass

def display():
	for name in list(phone_book.keys()):
		print("[%s: %s]" % (name, phone_book[name]))
	pass

phone_book = {}
while(True):
	cmd = int(input("(1) 신규, (2) 삭제, (3) 조회, (4) 종료 >> "))
	if cmd == 4:
		break
	if cmd == 1:
		insert()
	if cmd == 2:
		remove()
	if cmd == 3:
		display()
 
