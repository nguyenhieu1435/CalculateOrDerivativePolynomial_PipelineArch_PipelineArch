### Chúng ta cần tách các đa thức thành phần tử do đó cần 1 Class chứa các states của Phần tử

![image](https://github.com/nguyenhieu1435/CalculateOrDerivativePolynomial_PipelineArch_PipelineArch/assets/70377398/58888587-b1c6-4eec-893f-f166b194ac03)

### Tính đa thức gồm 2 Filter:  Filter 1: xử lý chia các đa thức thành List các phần tử từ trái qua phải, Filter 2: thực hiện tính giá trị của mỗi phần tử khi có x và tổng lại

![image](https://github.com/nguyenhieu1435/CalculateOrDerivativePolynomial_PipelineArch_PipelineArch/assets/70377398/df1348b3-52de-465e-a281-974815768337)

### Tính đạo hàm gồm 2 Filter: Filter 1: xử lý chia các đa thức thành List các phần tử từ trái qua phải, Fitler 2: thực hiện tính đạo hàm của từng phần tử trong danh sách, tính đạo hàm của 1 phần tử xong thực hiện nối vào chuỗi tạo trước khi lặp và trả về 1 đa thức đã đạo hàm

![image](https://github.com/nguyenhieu1435/CalculateOrDerivativePolynomial_PipelineArch_PipelineArch/assets/70377398/48583c7a-2dd2-400b-bba3-55d52a887113)
