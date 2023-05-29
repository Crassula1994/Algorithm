package silver4.num01049;

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
		
		// StringTokenzier 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 끊어진 기타줄의 개수와 브랜드의 개수를 각 변수에 할당
		int stringNum = Integer.parseInt(st.nextToken());
		int brandNum = Integer.parseInt(st.nextToken());
		
		// 최소 패키지 가격 및 낱개의 가격을 저장할 각 변수 초기화
		int minPackagePrice = Integer.MAX_VALUE;
		int minUnitPrice = Integer.MAX_VALUE;
		
		// for 반복문을 사용해 각 브랜드를 순회
		for (int brand = 0; brand < brandNum; brand++) {
			
			// StringTokenzier 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 패키지 가격 및 낱개의 가격을 각 변수에 할당
			int packagePrice = Integer.parseInt(st.nextToken());
			int unitPrice = Integer.parseInt(st.nextToken());
			
			// min() 메서드를 사용해 최소 패키지 가격 및 낱개의 가격을 갱신
			minPackagePrice = Math.min(packagePrice, minPackagePrice);
			minUnitPrice = Math.min(unitPrice, minUnitPrice);
		}
		
		// 모두 패키지로 사는 경우, 모두 낱개로 사는 경우, 각각을 별개로 사는 경우를 계산해 각 변수에 할당
		int casePackage = (stringNum % 6 == 0) ? (stringNum / 6) * minPackagePrice : (stringNum / 6 + 1) * minPackagePrice;
		int caseUnit = stringNum * minUnitPrice;
		int caseMix = (stringNum % 6 == 0) ? (stringNum / 6) * minPackagePrice : (stringNum / 6) * minPackagePrice + (stringNum % 6) * minUnitPrice;
		
		// min 메서드를 사용해 필요한 돈의 최솟값을 변수 result에 할당
		int result = Math.min(caseMix, Math.min(casePackage, caseUnit));
		
		// valueOf() 및 write() 메서드를 사용해 필요한 돈의 최솟값를 출력
		out.write(String.valueOf(result));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}