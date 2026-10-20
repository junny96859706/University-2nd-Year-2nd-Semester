import json, os
import numpy as np

DB_PATH = "face_db.json"


def load(path=DB_PATH):  # JSON 파일을 읽어 딕셔너리를 리턴
	if not os.path.exists(path):
		return {}  # 빈 딕셔너리 리턴

	f = open(path, "r", encoding="utf-8")
	raw = json.load(f)  # JSON 파일을 dict로 변환
	f.close()

	db = {}  # db 초기화
	for name, embs in raw.items():
		db[name] = []  # name에 해당하는 numpy 배열 리스트 초기화
		for e in embs:
			arr = np.array(e, dtype=np.float32)  # 숫자 배열을 numpy 배열로 변환
			db[name].append(arr)  # 변환된 numpy 배열을 name의 리스트에 추가
	return db


def save(db, path=DB_PATH):  # numpy 배열을 리스트로 변환 후 JSON 파일로 저장
	raw = {}  # raw 초기화
	for name, embs in db.items():
		raw[name] = []  # name에 해당하는 리스트 초기화
		for e in embs:
			lst = e.astype(float).tolist()  # numpy 배열을 리스트로 변환
			raw[name].append(lst)  # 변환된 리스트를 해당 이름(name)의 리스트에 추가

	f = open(path, "w", encoding="utf-8")
	json.dump(raw, f, ensure_ascii=False, indent=2)  # raw를 JSON 파일로 저장
	f.close()


def add(db, name, emb):  # db에 이름이 없으면 빈 리스트를 만들고 임베딩 추가
	db.setdefault(name, [])  # 이름(name)이 없으면 빈 리스트로 초기화
	db[name].append(emb.astype(np.float32))  # 임베딩을 float32로 변환하여 추가


def cosine(a, b):  # 두 벡터의 코사인 유사도 계산 (-1 ~ 1, 1에 가까울수록 유사)
	a = a.astype(np.float32)
	b = b.astype(np.float32)
	dot = np.dot(a, b)  # 내적 계산
	norm = np.linalg.norm(a) * np.linalg.norm(b) + 1e-9  # 크기의 곱
	return float(dot / norm)


def match(db, emb, threshold=0.65):  # db에서 emb와 가장 유사도가 높은 이름과 유사도 리턴
	best_name, best_score = None, -1.0
	for name, embs in db.items():  # 각 사람에 대하여
		for e in embs:  # 각 사람의 임베딩 벡터에 대하여
			s = cosine(emb, e)
			if s > best_score:  # 더 큰 유사도를 가진다면
				best_score, best_name = s, name  # 새로운 사람으로 교체

	if best_score >= threshold:  # threshold 보다 크면 인식
		return best_name, best_score
	return None, best_score  # 유사도가 threshold 미만이면 이름 대신 None을 리턴