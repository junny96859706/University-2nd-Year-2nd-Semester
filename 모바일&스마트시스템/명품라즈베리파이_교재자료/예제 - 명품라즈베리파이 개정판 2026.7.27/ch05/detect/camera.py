import cv2

_camera = None  # OpenCV의 VideoCapture 객체 참조


def init(camera_id=0, width=640, height=480, buffer_size=1):
	global _camera  # 전역 변수 _camera 사용 선언

	if _camera is not None:  # 카메라가 이미 오픈 되어 있으면
		release()  # 기존 카메라 해제

	_camera = cv2.VideoCapture(camera_id)  # 카메라 열기

	try:
		_camera.set(cv2.CAP_PROP_BUFFERSIZE, buffer_size)  # 버퍼 크기 설정
	except Exception:
		pass  # 버퍼 크기 설정 미지원 시 무시

	_camera.set(cv2.CAP_PROP_FRAME_WIDTH, width)   # 프레임 가로 크기 설정
	_camera.set(cv2.CAP_PROP_FRAME_HEIGHT, height)  # 프레임 세로 크기 설정

	if not _camera.isOpened():  # 카메라 열기 실패 시
		_camera = None  # 전역 변수 초기화
		raise RuntimeError(f"카메라 열기 실패: camera_id={camera_id}")


def read():
	if _camera is None:  # 카메라 미초기화 시
		return None  # None 반환
	ok, frame = _camera.read()  # 프레임 1장 읽기
	return frame if ok else None  # 실패 시 None 반환


def release():
	global _camera  # 전역 변수 사용 선언
	if _camera is not None:  # 카메라가 열려있으면
		_camera.release()  # 카메라 자원 해제
		_camera = None  # 전역 변수 초기화