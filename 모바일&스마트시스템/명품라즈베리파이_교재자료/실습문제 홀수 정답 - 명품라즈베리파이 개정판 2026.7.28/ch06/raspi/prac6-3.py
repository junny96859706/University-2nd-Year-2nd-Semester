import os
from flask import Flask, request, render_template

file_name = "./memo.txt"
app = Flask(__name__)

# /editor은 get, post를 모두 받아야 하므로 methods는 반두시 지정해야 함
@app.route("/editor", methods=["GET", "POST"])
def editor():
	if request.method == "GET": # 맨처음은 get방식으로 접속
		memo = ""
		if os.path.isfile(file_name) == True: # 파일이 이미 있으면
			file = open(file_name, "r")
			memo = file.read() # 기존의 내용을 memo에 채움
			file.close()
		pass

		return render_template("editor.html", memo = memo)
	pass

	# post로 받았다는 것은 저장 버턴을 클릭하였으므로 저장
	memo = request.form["memo"]
	file = open(file_name, "w")
	file.write(memo)
	file.close()

	return "<h2>memo.txt 파일에 저장 되었습니다"

if __name__ == "__main__":
	app.run(host="0.0.0.0", port=8080, debug=True)
