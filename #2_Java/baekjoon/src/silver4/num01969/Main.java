package silver4.num01969;

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

		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 DNA의 수 및 문자열의 길이를 각 변수에 할당
		int dnaNum = Integer.parseInt(st.nextToken());
		int stringLen = Integer.parseInt(st.nextToken());

		// 각 뉴클레오티드의 개수를 저장할 2차원 배열 nucleotides 초기화
		int[][] nucleotides = new int[stringLen][4];
		
		// for 반복문을 사용해 각 DNA를 순회
		for (int d = 0; d < dnaNum; d++) {
			
			// readLine() 메서드를 사용해 입력 받은 DNA를 변수 dna에 할당
			String dna = in.readLine();
			
			// for 반복문을 사용해 DNA의 각 뉴크레오티드를 순회
			for (int idx = 0; idx < stringLen; idx++) {
				
				// charAt() 메서드를 사용해 해당 뉴클레오티드를 변수 nucleotide에 할당
				char nucleotide = dna.charAt(idx);
				
				// switch 조건문을 사용해 해당 자리의 뉴클레오티드의 개수를 갱신
				switch (nucleotide) {
					case 'A':
						nucleotides[idx][0]++;
						break;
					case 'C':
						nucleotides[idx][1]++;
						break;
					case 'G':
						nucleotides[idx][2]++;
						break;
					case 'T':
						nucleotides[idx][3]++;
				}
			}
		}
			
		// 해밍 거리(Hamming Distance)가 가장 작은 DNA와 해밍 거리를 나타낼 각 변수 초기화
		StringBuilder minDna = new StringBuilder();
		int hammingDistance = stringLen * dnaNum;
		
		// for 반복문을 사용해 DNA의 각 자리를 순회
		for (int r = 0; r < stringLen; r++) {
			
			// 가장 많은 뉴클레오티드 및 그 개수를 저장할 각 변수 초기화
			int maxNucleotide = -1;
			int maxCnt = Integer.MIN_VALUE;
			
			// for 반복문을 사용해 각 자리의 뉴클레오티드 개수를 순회
			for (int c = 0; c < 4; c++) {
				
				// 해당 뉴클레오티드가 현재 가장 많은 뉴클레오티드인 경우 각 변수 갱신
				if (nucleotides[r][c] > maxCnt) {
					maxNucleotide = c;
					maxCnt = nucleotides[r][c];
				}
			}
			
			// switch 조건문을 사용해 해당 자리의 뉴클레오티드를 갱신
			switch (maxNucleotide) {
				case 0:
					minDna.append("A");
					break;
				case 1:
					minDna.append("C");
					break;
				case 2:
					minDna.append("G");
					break;
				case 3:
					minDna.append("T");
			}
			
			// 해밍 거리를 갱신
			hammingDistance -= maxCnt;
		}

		// write() 메서드를 사용해 해밍 거리가 가장 작은 DNA와 해밍 거리를 출력
		out.write(minDna + "\n" + hammingDistance);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}