package silver3.num19637;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Title 클래스 정의
	static class Title {
		
		// 칭호의 이름과 전투력 상한값을 저장할 각 변수 초기화
		String name;
		int maxStat;
		
		// 매개변수를 입력 받는 생성자 정의
		public Title(String name, int maxStat) {
			this.name = name;
			this.maxStat = maxStat;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 칭호의 개수 및 칭호를 출력할 캐릭터들의 개수를 각 변수에 할당
		int titleNum = Integer.parseInt(st.nextToken());
		int characterNum = Integer.parseInt(st.nextToken());
		
		// 각 칭호의 정보를 저장할 배열 titles 초기화
		Title[] titles = new Title[titleNum];
		
		// for 반복문을 사용해 각 칭호를 순회
		for (int idx = 0; idx < titles.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 칭호의 이름 및 전투력 상한값을 각 변수에 할당
			String name = st.nextToken();
			int maxStat = Integer.parseInt(st.nextToken());
			
			// 해당 칭호를 배열 titles에 저장
			titles[idx] = new Title(name, maxStat);
		}
		
		// for 반복문을 사용해 각 캐릭터를 순회
		for (int character = 0; character < characterNum; character++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 캐릭터의 전투력을 변수 stat에 할당
			int stat = Integer.parseInt(in.readLine());
			
			// 캐릭터의 칭호를 찾기 위해 필요한 칭호의 위치를 저장할 각 변수 초기화
			int start = 0;
			int end = titleNum;
			
			// while 반복문을 사용해 필요한 칭호를 찾을 때까지 순회
			while (start < end) {
				
				// 칭호 범위의 중간 위치를 찾아 변수 mid에 할당
				int mid = (start + end) / 2;
				
				// 해당 위치에 해당하는 칭호의 전투력 상한값이 해당 캐릭터의 전투력보다 작은 경우 범위의 시작 위치를 갱신
				if (titles[mid].maxStat < stat) {
					start = mid + 1;
					
				// 해당 위치에 해당하는 칭호의 전투력 상한값이 해당 캐릭터의 전투력보다 크거나 같은 경우 범위의 끝 위치를 갱신
				} else {
					end = mid;
				}
			}
			
			// write() 메서드를 사용해 캐릭터의 전투력에 맞는 칭호를 출력
			out.write(titles[end].name + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}