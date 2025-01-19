package silver3.num20115;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 페인이 가지고 있는 에너지 드링크의 수를 변수 drinkNum에 할당
		int drinkNum = Integer.parseInt(in.readLine());
		
		// 입력 받은 각 에너지 드링크의 양을 저장할 배열 energyDrinks 초기화
		double[] energyDrinks = new double[drinkNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 에너지 드링크의 양을 배열 energyDrinks에 저장
		for (int idx = 0; idx < energyDrinks.length; idx++)
			energyDrinks[idx] = Double.parseDouble(st.nextToken());
		
		// sort() 메서드를 사용해 에너지 드링크의 양을 오름차순으로 정렬
		Arrays.sort(energyDrinks);
		
		// 페인이 최대로 만들 수 있는 에너지 드링크의 양을 저장할 변수 maxAmount 초기화
		double maxAmount = energyDrinks[drinkNum - 1];
		
		// for 반복문을 사용해 각 에너지 드링크의 절반을 가장 많은 에너지 드링크에 더하고 최대로 만들 수 있는 에너지 드링크의 양을 갱신
		for (int idx = 0; idx < energyDrinks.length - 1; idx++)
			maxAmount += energyDrinks[idx] / 2;
		
		// format() 및 write() 메서드를 사용해 페인이 최대로 만들 수 있는 에너지 드링크의 양을 출력
		out.write(String.format("%.5f", maxAmount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}