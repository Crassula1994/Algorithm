package silver3.num18310;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 집의 개수를 변수 houseNum에 할당
		int houseNum = Integer.parseInt(in.readLine());
		
		// 각 집의 위치를 저장할 배열 location 초기화
		int[] location = new int[houseNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 집의 위치를 배열 location에 저장
		for (int idx = 0; idx < location.length; idx++)
			location[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 배열 location을 오름차순으로 정렬
		Arrays.sort(location);
		
		// 안테나의 설치 위치를 변수 antenna에 저장
		int antenna = (houseNum % 2 == 0) ? location[houseNum / 2 - 1] : location[houseNum / 2];
		
		// valueOf() 및 write() 메서드를 사용해 안테나의 설치 위치를 출력
		out.write(String.valueOf(antenna));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}