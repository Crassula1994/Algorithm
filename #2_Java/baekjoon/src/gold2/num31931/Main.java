package gold2.num31931;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 나루토와 사스케의 체력, 공격력, 회복력을 저장할 각 변수 초기화
	static long staminaN;
	static long staminaS;
	static long attackN;
	static long attackS;
	static long recoveryN;
	static long recoveryS;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseLong() 메서드를 사용해 나루토와 사스케의 체력을 각 변수에 할당
			staminaN = Long.parseLong(st.nextToken());
			staminaS = Long.parseLong(st.nextToken());
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 나루토와 사스케의 공격력과 회복력을 각 변수에 할당
			attackN = Long.parseLong(st.nextToken());
			recoveryN = Long.parseLong(st.nextToken());
			attackS = Long.parseLong(st.nextToken());
			recoveryS = Long.parseLong(st.nextToken());
			
			// fightSimulator() 메서드를 호출해 혈투의 결과를 출력
			out.write(fightSimulator());
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// fightSimulator() 메서드 정의
	public static String fightSimulator() {
		
		// 나루토가 사스케를 한 번만에 이길 수 있는 경우 'NARUTO' 반환
		if (attackN >= staminaS)
			return "NARUTO";
		
		// 사스케가 나루토를 한 번만에 이길 수 있는 경우 'SASUKE' 반환
		if (attackS >= staminaN + recoveryN)
			return "SASUKE";
		
		// 나루토의 공격력이 사스케의 회복력보다 높은 경우
		if (attackN > recoveryS) {
			
			// 나루토의 회복력이 사스케의 공격력보다 높은 경우 무조건 나루토가 이길 수 있으므로 'NARUTO' 반환
			if (recoveryN > attackS)
				return "NARUTO";
			
			// 나루토가 죽기 전에 사스케를 공격할 수 있는 횟수를 계산해 변수 attackCount에 할당
			long attackCount = (staminaN % attackS == 0) ? staminaN / attackS : staminaN / attackS + 1;
			
			// valueOf() 및 multiply() 메서드를 사용해 나루토가 사스케에게 입힌 피해를 변수 totalDamage에 할당
			BigInteger totalDamage = BigInteger.valueOf(attackCount).multiply(BigInteger.valueOf(attackN));
			
			// 나루토가 사스케에게 입힌 피해가 사스케의 체력 이상인 경우 나루토가 이길 수 있으므로 'NARUTO' 반환
			if (totalDamage.compareTo(BigInteger.valueOf(staminaS)) >= 0)
				return "NARUTO";
		}
		
		// 사스케의 공격력이 나루토의 회복력보다 높은 경우
		if (attackS > recoveryN) {
			
			// 사스케의 회복력이 나루토의 공격력보다 높은 경우 무조건 사스케가 이길 수 있으므로 'SASUKE' 반환
			if (recoveryS > attackN)
				return "SASUKE";
			
			// 사스케가 죽기 전에 나루토를 공격할 수 있는 횟수를 계산해 변수 attackCount에 할당
			long attackCount = (staminaS % attackN == 0) ? staminaS / attackN - 1 : staminaS / attackN;
			
			// valueOf() 및 multiply() 메서드를 사용해 사스케가 나루토에게 입힌 피해를 변수 totalDamage에 할당
			BigInteger totalDamage = BigInteger.valueOf(attackCount).multiply(BigInteger.valueOf(attackS));
			
			// 사스케가 나루토에게 입힌 피해가 나루토의 체력 이상인 경우 사스케가 이길 수 있으므로 'SASUKE' 반환
			if (totalDamage.compareTo(BigInteger.valueOf(staminaN)) >= 0)
				return "SASUKE";
		}
		
		// 무승부인 경우 'DRAW'를 반환
		return "DRAW";
	}
}