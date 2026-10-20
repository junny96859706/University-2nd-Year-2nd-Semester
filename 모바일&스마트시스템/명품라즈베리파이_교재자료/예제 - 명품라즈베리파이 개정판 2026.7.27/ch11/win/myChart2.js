let ctx = null;
let chart = null;
let config = {
	// type은 차트 종류 지정
	type: 'bar', /* line 등으로 바꿀 수 있음 */
	// data는 차트에 출력될 전체 데이터 표현
	data: {
		// labels는 배열로 데이터의 레이블들
		labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
		// datasets 배열로 차트에 그려질 모든 데이터 셋 표현. 
		// 아래는 그래프 1개만 있는 경우
		datasets: [{
			label: '2023년',
			backgroundColor: 'rgb(255, 99, 132)',
			borderColor: 'yellow',
			borderWidth: 2,		
			data: [5, 10, 5, 2, 20, 30, 45], // 각 레이블에 해당하는 데이터
			fill: true // 그래프에 색을 채울지 지정
		},
		{
			label: '2024년',
			backgroundColor: 'blue',
			borderColor: 'yellow',
			borderWidth: 0,
			data: [20, 56, 45, 34, 55, 70, 28], // 각 레이블에 해당하는 데이터
			fill: true // 그래프에 색을 채울지 지정
		}]
	},	

	// 차트의 속성 지정
	options: {
		responsive : false, // 웹 브라우저의 크기에 따른 크기 조절 금지
		scales: { // x축과 y축 정보 
			xAxes: [{
				display: true,
				scaleLabel: { display: true, labelString: '계절' },
			}],
			yAxes: [{
				display: true,
				scaleLabel: { display: true, labelString: '선호도(%)' },
				ticks: { // y축 눈금은 0~100까지
					min: 0,
					max: 100
				}	
			}]
		}
	}
};

function drawChart() {
	ctx = document.getElementById('canvas').getContext('2d');
	chart = new Chart(ctx, config); // Chart 객체 생성. 캔버스에 차트 그려짐
}

function change(month, val1, val2) { // 첫 레이블 이름을 month로 바꾸고, 첫 번째 그래프 값은 val1로, 두 번째 그래프 값은 val2로 변경
	chart.data.labels[0] = month; // 첫 레이블 이름을 month로 변경
	chart.data.datasets[0].data[0] = val1; // 첫 번째 그래프의 첫 막대 값을 val1로 변경
	chart.data.datasets[1].data[0] = val2; // 두 번째 그래프의 첫 막대 값을 val2로 변경
	chart.update(); // 갱신된 차트를 화면에 그림
}

function add(label, val1, val2) { // 그래프에 label 이름의 새로운 레이블을 추가하고, 첫 번째 그래프 값을 val1로, 두 번째 그래프 값을 val2로 지정
	chart.data.labels.push(label); // 새 레이블 이름을 labels[] 배열의 끝에 추가
	chart.data.datasets[0].data.push(val1); // 첫 번째 그래프의 값을 data[] 배열에 추가
	chart.data.datasets[1].data.push(val2); // 두 번째 그래프의 값을 data[] 배열에 추가
	chart.update(); // 갱신된 차트를 화면에 그림
}

function remove() { // 그래프에서 맨 앞 막대 제거
	chart.data.labels.shift(); // labels[] 배열에서 맨 앞 원소 제거
	chart.data.datasets[0].data.shift(); // 첫 번째 그래프의 data[] 배열에서 맨 앞 원소 제거
	chart.data.datasets[1].data.shift(); // 두 번째 그래프의 data[] 배열에서 맨 앞 원소 제거
	chart.update(); // 갱신된 차트를 화면에 그림
}