package gold4.num23309;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 역의 개수 및 공사 횟수를 각 변수에 할당
		int stationNum = Integer.parseInt(st.nextToken());
		int constructions = Integer.parseInt(st.nextToken());

		// 각 역의 출발 역과 도착 역의 정보를 저장할 각 배열 초기화
		int[] prevStation = new int[1000001];
		int[] nextStation = new int[1000001];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 첫 역을 변수 current에 할당
		int current = Integer.parseInt(st.nextToken());
		
		// 처음 역 정보 초기화
		prevStation[current] = current;
		nextStation[current] = current;
		
		// for 반복문을 사용해 역의 이전 역과 다음 역 정보를 각 배열에 추가
		for (int idx = 0; idx < stationNum - 1; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 역을 변수 post에 할당
			int post = Integer.parseInt(st.nextToken());
			
			// 이전 역과 다음 역 정보 추가
			prevStation[post] = current;
			nextStation[post] = nextStation[current];
			prevStation[nextStation[post]] = post;
			nextStation[current] = post;
			
			// 다음 역 정보를 current에 갱신
			current = post;
		}

		// for 반복문을 사용해 각 공사를 순회
		for (int c = 0; c < constructions; c++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 메서드를 사용해 입력 받은 공사 정보를 변수 constInfo에 저장
			String constInfo = st.nextToken();
			
			// 공사 정보에 필요한 정보를 저장할 각 변수 초기화
			int target = 0;
			int builded = 0;
			int closed = 0;
			int connected = 0;
			
			// switch 조건문을 사용해 공사 정보에 따라 정해진 명령을 수행
			switch (constInfo) {
			
				// 공사 정보 'BN'을 입력한 경우
				case "BN":
					
					// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 역을 각 변수에 저장
					target = Integer.parseInt(st.nextToken());
					builded = Integer.parseInt(st.nextToken());
					
					// 건설될 역과 연결될 다른 역을 변수 connected에 할당
					connected = nextStation[target];
					
					// write() 메서드를 사용해 해당 역의 다음 역의 번호를 출력
					out.write(connected + "\n");
					
					// 새로운 역의 정보 추가
					prevStation[builded] = target;
					nextStation[builded] = connected;
					
					// 이전 역과 다음 역의 정보 갱신
					nextStation[target] = builded;
					prevStation[connected] = builded;
					
					// 조건문 탈출
					break;
				
				// 공사 정보 'BP'을 입력한 경우
				case "BP":
					
					// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 역을 각 변수에 저장
					target = Integer.parseInt(st.nextToken());
					builded = Integer.parseInt(st.nextToken());
					
					// 건설될 역과 연결될 다른 역을 변수 connected에 할당
					connected = prevStation[target];
					
					// write() 메서드를 사용해 해당 역의 이전 역의 번호를 출력
					out.write(connected + "\n");
					
					// 새로운 역의 정보 추가
					prevStation[builded] = connected;
					nextStation[builded] = target;
					
					// 이전 역과 다음 역의 정보 갱신
					nextStation[connected] = builded;
					prevStation[target] = builded;
					
					// 조건문 탈출
					break;
					
				// 공사 정보 'CN'을 입력한 경우
				case "CN":
					
					// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 역을 변수 target에 저장
					target = Integer.parseInt(st.nextToken());
					
					// 폐쇄되는 역과 다시 연결될 역을 각 변수에 저장
					closed = nextStation[target];
					connected = nextStation[closed];
					
					// write() 메서드를 사용해 폐쇄되는 역의 번호를 출력
					out.write(closed + "\n");
						
					// 이전 역과 다음 역의 정보를 갱신
					nextStation[target] = connected;
					prevStation[connected] = target;
					
					// 조건문 탈출
					break;

				// 공사 정보 'CP'를 입력한 경우
				default:
					
					// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 역을 변수 target에 저장
					target = Integer.parseInt(st.nextToken());
					
					// 폐쇄되는 역과 다시 연결될 역을 각 변수에 저장
					closed = prevStation[target];
					connected = prevStation[closed];
					
					// write() 메서드를 사용해 폐쇄되는 역의 번호를 출력
					out.write(closed + "\n");
					
					// 이전 역과 다음 역의 정보를 갱신
					prevStation[target] = connected;
					nextStation[connected] = target;
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}