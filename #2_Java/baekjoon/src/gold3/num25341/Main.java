package gold3.num25341;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 입력층의 입력 크기, 은닉층의 인공 신경 개수,
		출력값을 계산해야 하는 횟수를 각 변수에 할당 */
		int inputSize = Integer.parseInt(st.nextToken());
		int nerveNum = Integer.parseInt(st.nextToken());
		int calcCnt = Integer.parseInt(st.nextToken());
		
		// 각 은닉층과 출력층의 입력 데이터, 가중치, 편향값 정보, 각 입력 데이터에 대한 최종 가중치를 저장할 각 배열 초기화
		List<Integer>[] inputs = new ArrayList[nerveNum];
		List<Integer>[] weights = new ArrayList[nerveNum + 1];
		int[] biasValues = new int[nerveNum + 1];
		long[] totalWeights = new long[inputSize + 1];
		
		// for 반복문을 사용해 각 은닉층과 출력층의 입력 데이터를 저장할 각 List 객체 초기화
		for (int idx = 0; idx < inputs.length; idx++)
			inputs[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 은닉층과 출력층의 가중치를 저장할 각 List 객체 초기화
		for (int idx = 0; idx < weights.length; idx++)
			weights[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 은닉층의 정보를 순회
		for (int idx = 0; idx < nerveNum; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 인공 신경의 입력 개수를 변수 count에 할당
			int count = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 입력 받은 은닉층의 입력 데이터를 배열 inputs에 저장
			for (int c = 0; c < count; c++)
				inputs[idx].add(Integer.parseInt(st.nextToken()));
			
			// for 반복문을 사용해 입력 받은 은닉층의 가중치를 배열 weights에 저장
			for (int c = 0; c < count; c++)
				weights[idx].add(Integer.parseInt(st.nextToken()));
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 은닉층의 편향값을 배열 biasValues에 저장
			biasValues[idx] = Integer.parseInt(st.nextToken());
		}
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 출력층의 가중치를 배열 weights에 저장
		for (int c = 0; c < nerveNum; c++)
			weights[nerveNum].add(Integer.parseInt(st.nextToken()));
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 출력층의 편향값을 배열 biasValues에 저장
		biasValues[nerveNum] = Integer.parseInt(st.nextToken());
		
		// 편향값의 총합을 초기화
		totalWeights[0] = biasValues[nerveNum];
		
		// for 반복문을 사용해 각 은닉층을 순회
		for (int idx = 0; idx < nerveNum; idx++) {
			
			// get() 메서드를 사용해 편향값의 총합을 갱신
			totalWeights[0] += biasValues[idx] * weights[nerveNum].get(idx);
			
			// for 반복문을 사용해 해당 은닉층의 각 입력 데이터의 최종 가중치를 갱신
			for (int input = 0; input < inputs[idx].size(); input++)
				totalWeights[inputs[idx].get(input)] += weights[idx].get(input) * weights[nerveNum].get(idx);
		}
		
		// while 반복문을 사용해 각 입력 데이터를 순회
		while (calcCnt-- > 0) {
			
			// 해당 입력 데이터의 출력값을 저장할 변수 output 초기화
			long output = totalWeights[0];
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 해당 입력 데이터의 출력값을 갱신
			for (int idx = 1; idx <= inputSize; idx++)
				output += Integer.parseInt(st.nextToken()) * totalWeights[idx];
			
			// write() 메서드를 사용해 해당 입력 데이터의 출력값을 출력
			out.write(output + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}