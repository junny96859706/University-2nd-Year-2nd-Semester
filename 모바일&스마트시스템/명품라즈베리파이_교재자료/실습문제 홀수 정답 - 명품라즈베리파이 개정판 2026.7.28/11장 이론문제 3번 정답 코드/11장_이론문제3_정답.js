let ctx = null;
let chart = null;
let config = {
	// type은 차트 종류 지정
	type: 'bar', /* line 등으로 바꿀 수 있음 */
	// data는 차트에 출력될 전체 데이터 표현
	data: {
	// labels는 배열로 데이터의 레이블들
	labels: ['Java', '웹프로그래밍', '컴퓨터구조', '모바일스마트'],
	
		// datasets 배열로 차트에 그려질 모든 데이터 셋 표현.
		// 아래는 그래프 1개만 있는 경우
		datasets: [ {
			label: '과목별 성적',
			backgroundColor: 'rgb(255, 99, 132)',
			borderColor: 'yellow',
			borderWidth: 2,
			data: [95, 88, 72, 99], // 각 레이블에 해당하는 데이터
			fill: true // 그래프에 색을 채울지 지정
		}]
	},

	// 차트의 속성 지정
	options: {
		responsive : false, // 웹 브라우저의 크기에 따른 크기 조절 금지
		scales: { // x축과 y축 정보
			x: {
				display: true,
				title: { display: true, text: '과목' },
			},
			y: {
				display: true,
				title: { display: true, text: '성적(점수)' },
				min: 70, // y축 최소 눈금
				max:100, // y축 최대 눈금
				ticks: {stepSize: 5}
			}
		}
	}
};

function drawChart() { // Chart 객체 생성 및 차트 그리기
	ctx = document.getElementById('canvas').getContext('2d');
	chart = new Chart(ctx, config); // Chart 객체 생성. 캔버스에 차트 그려짐
}