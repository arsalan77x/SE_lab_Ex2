# گزارش آزمایش دوم - Test-driven developement (TDD)
در این آزمایش ابتدا دو ایراد موجود در برنامه‌ی مربوط به مدیریت کتابخانه پیدا کرده و سپس برای آن دو تست یا آزمون واحد نوشته تا هدف و خواست ما از برنامه مشخص شود، سپس آن را اصلاح کرده و دوباره تست می‌گیریم. در ادامه نیز دو بخش ناقص کد را کامل می‌کنیم بدین صورت که ابتدا خواست ما از برنامه توسط چند آزمون واحد مشخص شده و سپس کد را کامل می‌کنیم.
<br>

## مراحل انجام آزمایش
### رفع ایرادات
قبل از بررسی ایرادات، ابتدا فایل LibraryTest.java را ساخته و تابع ()setup که قبل از هر تستی باید اجرا شود را تعریف می‌کنیم. این تابع پیش‌نیاز همه‌ی تست‌ها است که در شکل زیر مشخص شده است.
<br>
<p align="center">
  <img src="https://github.com/arsalan77x/SE_lab_2/assets/63359673/857b744c-f769-4cea-9112-1d1446670304" alt="Image Description">
<br>
  <em>تصویر 1</em>
</p>
<br>

ایراد اول کد در تابع lendBook در کلاس Library است(تصویر 2). طبق کامنت بالای آن، خواست ما این است که به دانشجویی که در کتابخانه ثبت‌نشده است کتاب ندهیم، اما این مورد برآورده نشده. پس مطابق تصویر 3 یک آزمون واحد نوشته که assert و انتظار ما این است که نتیجه‌ی هر دو false شود چراکه هم عمل lend نباید صورت گیرد و هم در لیست دانشجو نباید کتاب باشد.

<br>
<p align="center">
  <img src="https://github.com/arsalan77x/SE_lab_2/assets/63359673/857b744c-f769-4cea-9112-1d1446670304" alt="Image Description">
<br>
  <em>تصویر 2</em>
<br>
  <img src="https://github.com/arsalan77x/SE_lab_2/assets/63359673/5097199b-2738-4f5a-9ebf-d782e103b14e" alt="Image Description"> <br>
<em>تصویر 3</em>
</p>
<br>

برای رفع این مشکل کد تصویر 4 را اضافه کرده و مطابق تصویر 5 می‌بینیم که تست به درستی پاس می‌شود.


<br>
<p align="center">
  <img src="https://github.com/arsalan77x/SE_lab_2/assets/63359673/80589700-cf56-474a-9986-bc640789bb07" alt="Image Description">
<br>
  <em>تصویر 4</em>
<br>
  <img src="https://github.com/arsalan77x/SE_lab_2/assets/63359673/775caa83-5fa8-4944-84f3-9fc5806e22c6" alt="Image Description"> <br>
<em>تصویر 5</em>
</p>
<br>


ایراد دوم مربوط به تابع returnBook است که بعد از اینکه دانشجو کتاب را به کتابخانه تحویل داد، با اینکه کتاب به کتابخانه اضافه می‌شود ولی از لیست کتاب‌های دانشجو کم نمی‌شود پس خواست و هدف خود از برنامه را مطابق آزمون واحد زیر تعریف می‌کنیم. (تصویر 6) سپس کد برنامه را مطابق تصویر 7 اصلاح کرده (خط 65 کد) و دوباره تست می‌گیریم که نتیجه در تصویر 8 قابل مشاهده است.

<br>
<p align="center">
  <img src="https://github.com/arsalan77x/SE_lab_2/assets/63359673/8a6799ca-0b49-4837-b9c8-d06bc6f7fefa" alt="Image Description">
<br>
  <em>تصویر 6</em>
<br>
  <img src="https://github.com/arsalan77x/SE_lab_2/assets/63359673/939e5102-38e9-4d5c-ab28-61b93e587d12" alt="Image Description"> <br>
<em>تصویر 7</em>
  <br>
    <img src="https://github.com/arsalan77x/SE_lab_2/assets/63359673/27a93752-f0c9-44b7-ba86-caea0107e5ea" alt="Image Description"> <br>
<em>تصویر 8</em>
</p>
<br>