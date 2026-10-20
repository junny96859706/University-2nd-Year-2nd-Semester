from flask import Flask
app = Flask(__name__)

@app.route("/<float:op1>/<op>/<float:op2>/")
def calculate(op1, op, op2):
	if op == "plus":
		return "<h2>%f + %f = %f</h2>" % (op1, op2, op1+op2)
	if op == "minus":
		return "<h2>%f - %f = %f</h2>" % (op1, op2, op1-op2)
	if op == "multiply":
		return "<h2>%f * %f = %f</h2>" % (op1, op2, op1*op2)
	if op == "divide":
		if op2 == 0.0:
			return "<h2>0으로는 나눌수 없습니다</h2>"
		return "<h2>%f / %f = %f</h2>" % (op1, op2, op1/op2)
	return "<h2>연산자를 plus, minus, multiply, divide중의 하나를 사용하세요</h2>"

if __name__ == "__main__":
	app.run(host="0.0.0.0", port=8080, debug=True)

