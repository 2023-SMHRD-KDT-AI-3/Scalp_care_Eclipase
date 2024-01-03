package com.Iplus.entity;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

import org.tensorflow.SavedModelBundle;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.types.UInt8;


public class imgClassifier {
	
	 private SavedModelBundle model1;
	 private SavedModelBundle model2;
	 private SavedModelBundle model3;
	 private SavedModelBundle model4;
	 private SavedModelBundle model5;
	 private SavedModelBundle model6;


public ArrayList<String> predict(byte[] imgByte) {

	ArrayList<String> results = new ArrayList<String>();
	// 모델 연결
	String modelPath6 = "C:/Users/smhrd/Desktop/project/ai_model/model6/VGG19_v2-58-0.767";
    
//    model1 = SavedModelBundle.load(modelPath, "serve");
//    model2 = SavedModelBundle.load(modelPath, "serve");
//    model3 = SavedModelBundle.load(modelPath, "serve");
//    model4 = SavedModelBundle.load(modelPath, "serve");
//    model5 = SavedModelBundle.load(modelPath, "serve");
    model6 = SavedModelBundle.load(modelPath6, "serve");
    
    // 모델 사용 준비
    Session session = model6.session();
    
    // 모델에 들어갈 이미지 전처리
    long[] shape = new long[]{1, 224, 224, 3};
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(imgByte.length)
            .order(ByteOrder.nativeOrder());
    byteBuffer.put(imgByte);
    byteBuffer.rewind();
    
    Tensor<UInt8> tensor_img = Tensor.create(UInt8.class, shape, byteBuffer);
    
    // 모델에 입력
    Tensor<?> outputTensor = model6.session().runner()
            .feed("input_tensor_name", tensor_img)
            .fetch("output_tensor_name")
            .run()
            .get(0);
    
    
    // 입력된 모델에서 데이터 추출
    Object tensorData = outputTensor.copyTo(new float[1][4]); // 예: 2차원 float 배열로 변환
    
    // 가장 높은 확률을 가진 클래스 인덱스 찾기
    // 최대 확률을 가진 클래스의 인덱스
    int maxIndex = 0;
    
    // 텐서 데이터가 2차원 float 배열인지 확인
    if (tensorData instanceof float[][]) {
        // 2차원 배열로 캐스팅
        float[][] probabilities = (float[][]) tensorData;
        
        // 배열의 크기가 유효한지 확인
        if (probabilities.length > 0 && probabilities[0].length > 0) {
            float maxValue = probabilities[0][0]; // 최대 확률 값 초기화

            // 배열의 모든 열에 대해 반복
            for (int i = 0; i < probabilities[0].length; i++) {
                // 현재 열의 확률 값이 최대값보다 큰지 확인
                if (probabilities[0][i] > maxValue) {
                    maxValue = probabilities[0][i]; // 최대값 업데이트
                    maxIndex = i;                   // 최대값의 인덱스 업데이트
                }
            }
        }
    }
    
    // 결과 가져오기
    String result = "";
    switch (maxIndex) {
    case 0:
    	result = "양호"; // 클래스 인덱스 0은 "양호"으로 매핑
    case 1:
    	result = "경증"; // 클래스 인덱스 1은 "경증"으로 매핑
    case 2:
    	result = "중등도"; // 클래스 인덱스 2은 "중등도"으로 매핑
    case 3:
    	result = "중증"; // 클래스 인덱스 3은 "중증"으로 매핑
    }
    results.add(result);
    
    return results;
        
}

}
