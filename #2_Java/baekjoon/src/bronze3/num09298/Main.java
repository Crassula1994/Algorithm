package bronze3.num09298;

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
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 개미의 수를 변수 antNum에 할당
			int antNum = Integer.parseInt(in.readLine());
			
			// 개미가 있는 위치의 극한값을 저장할 각 변수 초기화
			double minX = Double.MAX_VALUE;
			double maxX = Double.NEGATIVE_INFINITY;
			double minY = Double.MAX_VALUE;
			double maxY = Double.NEGATIVE_INFINITY;
			
			// while 반복문을 사용해 각 개미의 위치를 순회
			while (antNum-- > 0) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseDouble() 메서드를 사용해 입력 받은 개미의 위치를 각 변수에 할당
				double coordinateX = Double.parseDouble(st.nextToken());
				double coordinateY = Double.parseDouble(st.nextToken());
				
				// min() 및 max() 메서드를 사용해 개미가 있는 위치의 극한값을 갱신
				minX = Math.min(coordinateX, minX);
				maxX = Math.max(coordinateX, maxX);
				minY = Math.min(coordinateY, minY);
				maxY = Math.max(coordinateY, maxY);
			}
			
			// 울타리의 넓이와 둘레를 계산해 각 변수에 할당
			double area = (maxX - minX) * (maxY - minY);
			double perimeter = ((maxX - minX) + (maxY - minY)) * 2;
			
			// format() 및 write() 메서드를 사용해 울타리의 넓이와 둘레를 출력
			out.write(String.format("Case %d: Area %.9f, Perimeter %.9f\n", tc, area, perimeter));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}