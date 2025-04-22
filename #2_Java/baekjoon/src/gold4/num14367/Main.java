package gold4.num14367;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 재킷, 바지, 셔츠의 개수, 두 옷 조합의 개수 제한을 각 변수에 할당
			int jacketNum = Integer.parseInt(st.nextToken());
			int pantsNum = Integer.parseInt(st.nextToken());
			int shirtNum = Integer.parseInt(st.nextToken());
			int countLimit = Integer.parseInt(st.nextToken());
			
			// 두 옷 조합의 개수 제한이 셔츠의 개수 이상인 경우 개수 제한이 의미가 없으므로 셔츠의 개수와 같은 값으로 갱신
			if (countLimit > shirtNum)
				countLimit = shirtNum;
			
			// format() 및 write() 메서드를 사용해 테스트 케이스 번호와 패션 감옥에 가지 않을 수 있는 최대 일수를 정해진 양식으로 출력
			out.write(String.format("Case #%d: %d\n", tc, jacketNum * pantsNum * countLimit));
			
			// for 반복문을 사용해 각 재킷을 순회
			for (int jacket = 1; jacket <= jacketNum; jacket++) {
				
				// for 반복문을 사용해 각 바지를 순회
				for (int pants = 1; pants <= pantsNum; pants++) {
					
					// for 반복문을 사용해 각 셔츠를 순회
					for (int count = 0; count < countLimit; count++) {
						
						// 해당 셔츠의 번호를 shirt에 할당
						int shirt = (jacket + pants + count - 1) % shirtNum + 1;
						
						// format() 및 write() 메서드를 사용해 해당 날짜에 입은 옷의 조합을 출력
						out.write(String.format("%d %d %d\n", jacket, pants, shirt));
					}
				}
			}
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}