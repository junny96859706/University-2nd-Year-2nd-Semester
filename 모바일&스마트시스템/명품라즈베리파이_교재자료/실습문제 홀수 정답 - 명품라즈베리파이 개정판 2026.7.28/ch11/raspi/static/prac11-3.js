let ctx = null;
let chart = null;
let config = {
	// type은 차트 종류 지정
	type: 'bar',

	// data는 차트에 출력될 전체 데이터 표현
	data: {
		// labels는 배열로 데이터의 레이블들
		labels: [],

		// datasets 배열로 차트에 그려질 모든 데이터 셋 표현. 
		// 아래는 그래프 1개만 있는 경우
		datasets: [ {
			label: '알파벳 히스토그램',
			backgroundColor: 'magenta',
			borderColor: 'skyblue',
			borderWidth: 2,		
			data: [], // 각 레이블에 해당하는 데이터
			fill: true, // 그래프에 색을 채울지 지정
		}]
	},	
      
	// 차트의 속성 지정
	options: {
		responsive : false, // 웹 브라우저의 크기에 따른 크기 조절 금지
		scales: { // x축과 y축 정보 
			x: {
				display: true,
				title: { display: true, text: '알파벳' },
			},
			y: {
				display: true,
				title: { display: true, text: '횟수(개)' },
				min: 0,
				max: 20, // 최대 20개			
				ticks: { stepSize: 2, autoSkip: false }
			}
		}
	}
};

function drawChart() { // Chart 객체 생성 및 차트 그리기
	ctx = document.getElementById('canvas').getContext('2d');
	chart = new Chart(ctx, config); // Chart 객체 생성. 캔버스에 차트 그려짐
	init();
}

function init() {
	let asciiCode = "a".charCodeAt(0)
	for(let i=0; i<26; i++) {
		chart.data.labels[i] = String.fromCharCode(asciiCode)
		asciiCode++;
		chart.data.datasets[0].data[i] = 0;
	}
	chart.update();
}

function changeChart(text) { // text 속의 알파벳을 분석하여 히스토그램을 만든다.
	text = text.toLowerCase(); // 대문자를 소문자로 변환한다.
	let a_asciiCode = "a".charCodeAt(0); // 문자열 “a”에서 첫 번째 문자(‘a’)의 ascii 코드 값
	let z_asciiCode = "z".charCodeAt(0); // ‘z’ 문자의 ascii 코드 값
	for(let i=0; i<text.length; i++) { // 텍스트에 포함된 문자의 개수만큼 루프
		let asciiCode = text.charCodeAt(i); // 텍스트에 들어 있는 i번째 문자의 ascii 코드
		if(asciiCode >= a_asciiCode && asciiCode <= z_asciiCode) { // 소문자인 경우
			let index = asciiCode -  a_asciiCode; // 문자의 배열 인덱스
			chart.data.datasets[0].data[index]++; // 카운트 1 증가
		}
	}
	chart.update(); // 차트 다시 그리기
}