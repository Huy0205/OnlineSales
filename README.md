## Các chức năng:
### Phía Client
1. Hiển thị trang Home
![screencapture-localhost-8080-client-index-2023-12-03-17_14_07](https://github.com/Huy0205/WWW_Lab07/assets/144652046/84a31072-02af-472a-bb1a-175144f954f8)
### Phía Admin
1. Quản lý product
![image](https://github.com/Huy0205/WWW_Lab07/assets/144652046/a3575c31-363b-4eae-8191-7d3262ffa9d8)
- Thêm một sản phẩm mới:
![image](https://github.com/Huy0205/WWW_Lab07/assets/144652046/080cb83f-9ef3-4b09-a8b4-83064ad5f8c2)
Sau khi nhập thông tin sản phẩm mới, nhấn vào Save thì sản phẩm sẽ được lưu và hiển thị thông báo tại trang danh sách sản phẩm:
![screencapture-localhost-8080-admin-products-2023-12-06-09_54_06](https://github.com/Huy0205/WWW_Lab07/assets/144652046/5051bce6-77bc-4301-a974-17a707553554)
Nếu sản phẩm thêm vào có tên và nhà sản xuất trùng với một sản phẩm bất kỳ trong danh sách thì sẽ thông báo và sản phẩm sẽ không được thêm vào:
![image](https://github.com/Huy0205/WWW_Lab07/assets/144652046/90a06969-c38a-43b2-b698-006fe6ce07d0)
- Cập nhật sản phẩm:
Cập nhật lại sản phẩm có id 1 với status mới là IN_ACTIVE:
![image](https://github.com/Huy0205/WWW_Lab07/assets/144652046/3e755d15-ca0c-46cf-80cd-48838ad0c446)
Sau khi cập nhật thành công sẽ hiện thông báo:
![screencapture-localhost-8080-admin-products-2023-12-06-11_56_25](https://github.com/Huy0205/WWW_Lab07/assets/144652046/70800471-7ef0-423d-9938-8ce89f79b80a)
Nếu thông tin cập nhật lại có tên và nhà sản xuất trùng với 1 sản phẩm khác trong danh sách:
![screencapture-localhost-8080-admin-products-update-2023-12-06-11_59_06](https://github.com/Huy0205/WWW_Lab07/assets/144652046/859dd5c3-b2c2-4cb6-b4fa-186d5d2413b3)
Ở đây ta cập nhật lại tên là iPhone SE và nhà sản xuất là QMobile bị trùng với sản phẩm có id 1 nên có thông bào như thông báo và không cho cập nhật lại sản phẩm
- Xóa 1 sản phẩm:
Xóa sản phẩm có id là 2, nhấn vào delete sẽ có hiện thông báo hỏi người dùng, nếu chọn ok thì mới xóa:
![image](https://github.com/Huy0205/WWW_Lab07/assets/144652046/ffddbc95-5910-49b7-a4e4-ae3e17abf49c)
Sản phẩm có id là 2 đã được xóa thành công:
![screencapture-localhost-8080-admin-products-2023-12-06-12_24_09](https://github.com/Huy0205/WWW_Lab07/assets/144652046/71644bd9-a726-43c0-84ec-82403bb1b085)
Thực chất sản phẩm có id là 2 không xóa hoàn toàn khỏi CSDL mà chỉ set lại status là TERMINATED, vì status là TERMINATED nên sẽ không được hiện trong trang danh sách:
![image](https://github.com/Huy0205/WWW_Lab07/assets/144652046/e642c007-962a-4c5a-a1f9-caef640d40f4)

