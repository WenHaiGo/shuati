package mysort;

//2018��1��3��09:59:35
//2018��1��3��10:41:27
//��һ��������й鲢����
//����˼����Ƿֳ�����:
//��������������ų�����ģ�Ȼ��ϲ�����
public class MergeOrder {

	static void mergeSort(int[] arr, int[] temp, int left, int right) {
//ע���������ĵݹ飬ִ�е�һ���ݹ鵽�׷���֮���ִ�еڶ����ݹ���ͼ��������ͼ�Ľ�ϱȽϺ����
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, temp, left, mid);
			mergeSort(arr, temp, mid + 1, right);
			merge(arr, temp, left, mid, right);
		}
	}

	// �˴�Ӧ��˼��Ϊʲô������Ҫ�ṩ�м�ֵ
	static void merge(int[] arr, int[] temp, int left, int mid, int right) {
		int i = left;
		int j = right;
		int k = mid + 1;
		int index = 0;
		while (i <= mid && k <= right) {
			if (arr[i] < arr[k]) {
				temp[index++] = arr[i++];
			}

			else {
				temp[index++] = arr[k++];
			}
		}

		while (i <= mid) {
			temp[index++] = arr[i++];
		}

		while (k <= right) {
			temp[index++] = arr[k++];
		}

		// �����temp��ԭ��arr����ȥ ��ע������������iӦ��С��ʲô
		for (i = 0; i < index; i++) {
			arr[left + i] = temp[i];
		}

	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 5, 0, 55, 4 };
		int[] temp = new int[arr.length];
		mergeSort(arr, temp, 0, arr.length - 1);

		for (int i : arr) {
			System.out.println(i);
		}

	}
}
