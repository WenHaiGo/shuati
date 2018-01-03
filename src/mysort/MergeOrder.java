package mysort;

//2018年1月3日09:59:35
//2018年1月3日10:41:27
//对一个数组进行归并排序
//主题思想就是分成两步:
//先用排序把两边排成有序的，然后合并起来
public class MergeOrder {

	static void mergeSort(int[] arr, int[] temp, int left, int right) {
//注意理解这里的递归，执行第一个递归到底返回之后会执行第二个递归结合图来理解二叉图的结合比较好理解
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, temp, left, mid);
			mergeSort(arr, temp, mid + 1, right);
			merge(arr, temp, left, mid, right);
		}
	}

	// 此处应该思考为什么排序不需要提供中间值
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

		// 必须把temp还原到arr里面去 【注】这里忘记了i应该小于什么
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
