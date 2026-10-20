import cv2
from flask import Flask, request, render_template
import camera # 카메라 모듈, camera.py 임포트
import base64

app = Flask(__name__)		# 플라스크 객체 생성
camera.init(width=320, height=240)	# 카메라 모듈 초기화

to_be_status = "stop"

base64_str = ""

@app.route("/cctv/")
def cctv():
	global base64_str

	image = camera.take_picture(most_recent=True)	# 사진 촬영. 이미지 읽기
	if image is not None:
		bytes = cv2.imencode(".jpg", image)[1].tobytes()
		base64_image = base64.b64encode(bytes)
		base64_str = "data:image/jpeg;base64,"+base64_image.decode("ascii")

	return render_template("cctv.html", mypath= "/cctv/", fname=base64_str, buttonTitle = to_be_status)

if __name__ == "__main__":
	app.run(host="0.0.0.0", port=8080) # debug=True 속성을 사용하면 오류 발생
