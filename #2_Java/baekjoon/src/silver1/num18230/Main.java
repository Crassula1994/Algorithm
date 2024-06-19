package silver1.num18230;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 바닥의 크기와 각 타일의 개수를 각 변수에 할당
		int width = Integer.parseInt(st.nextToken());
		int countA = Integer.parseInt(st.nextToken());
		int countB = Integer.parseInt(st.nextToken());
		
		// 타일들을 이용해 얻을 수 있는 화장실 바닥의 예쁨 최댓값을 저장할 변수 maxBeauty 초기화
		int maxBeauty = 0;
		
		// 각 타일의 예쁨 정도를 저장할 각 배열 초기화
		int[] beautyA = new int[countA];
		int[] beautyB = new int[countB];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 2×1 크기 타일의 예쁨 정도를 배열 beautyA에 저장
		for (int idx = 0; idx < countA; idx++)
			beautyA[idx] = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 2×2 크기 타일의 예쁨 정도를 배열 beautyB에 저장
		for (int idx = 0; idx < countB; idx++)
			beautyB[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 각 타일의 예쁨 정도를 오름차순으로 정렬
		Arrays.sort(beautyA);
		Arrays.sort(beautyB);
		
		// 다음에 사용할 각 타일의 인덱스를 저장할 각 변수 초기화
		int indexA = countA - 1;
		int indexB = countB - 1;
		
		// 화장실 바닥의 넓이가 홀수인 경우 2×1 크기 타일 중 가장 예쁜 타일을 사용한 것으로 처리
		if (width % 2 == 1)
			maxBeauty += beautyA[indexA--];
		
		// for 반복문을 사용해 각 화장실 바닥의 넓이를 순회
		for (int w = 0; w < width / 2; w++) {
			
			// 2×1 크기의 타일을 더 이상 사용할 수 없는 경우 2×2 크기의 타일을 사용한 것으로 처리
			if (indexA < 1) {
				maxBeauty += beautyB[indexB--];
				
			// 2×2 크기의 타일을 더 이상 사용할 수 없는 경우 2×1 크기의 타일을 사용한 것으로 처리
			} else if (indexB < 0) {
				maxBeauty += beautyA[indexA] + beautyA[indexA - 1];
				indexA -= 2;
				
			// 2×1 크기의 타일과 2×2 크기의 타일을 모두 사용할 수 있는 경우
			} else {
				
				// 2×1 크기의 타일을 사용하는 것이 더 예쁜 경우 2×1 크기의 타일을 사용한 것으로 처리
				if (beautyA[indexA] + beautyA[indexA - 1] > beautyB[indexB]) {
					maxBeauty += beautyA[indexA] + beautyA[indexA - 1];
					indexA -= 2;
					
				// 2×2 크기의 타일을 사용하는 것이 더 예쁘거나 예쁨의 정도가 같은 경우 2×2 크기의 타일을 사용한 것으로 처리
				} else {
					maxBeauty += beautyB[indexB--];
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 타일들을 이용하여 얻을 수 있는 화장실 바닥의 예쁨 최댓값을 출력
		out.write(String.valueOf(maxBeauty));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}