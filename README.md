# NavigationDrawer
Create Navigation Drawer in AndroidX

## Priview
![2](https://user-images.githubusercontent.com/43386555/64636125-46eb0380-d42b-11e9-9716-10dabdbaed1b.jpg)

toggle.syncState(); //use navigation icon burger

![images](https://user-images.githubusercontent.com/43386555/64635376-bd870180-d429-11e9-8194-ff238a86b757.jpg)

toolbar.setNavigationIcon(R.drawable.ic_account); //custome icon navigation

![1](https://user-images.githubusercontent.com/43386555/64636025-14410b00-d42b-11e9-91d8-0841b8da7165.png)


## 3. Tahap selanjutnya menu dapat di Klik
      1. Pada method onCreate
         tambahkan kode dibawah ini
         
         //setOnclick item menu navigation
        navigationView.setNavigationItemSelectedListener(this);
      
      2. Kita  tambahkan implements NavigationView.OnNavigationItemSelectedListener pada Class MainActivity
         seperti pada kode dibawah ini
         
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
         
      3. setlah kita implement NavigationViewnya maka ada error merah pada NavigationView
         selanjutnya kita implement method nya, kita boleh klik icon lampu yang merah itu atau bisa juga dengan ##ALT+ENTER
         seperti gambar dibawah ini
         
![Screen Shot 2019-09-11 at 01 11 00](https://user-images.githubusercontent.com/43386555/64639024-2cb42400-d431-11e9-9aeb-cf458f67c27e.png)

        Klik icon lampu sampai muncul popup dibawah seperti gambar ke 2, kemudian pilih yang pertama
gambar 1
![Screen Shot 2019-09-11 at 01 08 38](https://user-images.githubusercontent.com/43386555/64639180-81579f00-d431-11e9-98a3-47e37f0dd399.png)

gambar 2
![Screen Shot 2019-09-11 at 01 08 55](https://user-images.githubusercontent.com/43386555/64639189-87e61680-d431-11e9-91bb-7e85d100368a.png)


4. Setelah di implement method onNavigationItemSelected selanjutnya tambahkan kode dibawah ini sesuai ID yang akan di panggil menggunakan swict case atau bisa menggunakan if else itu selera kalian
      
      /*
    method from implements NavigationView.OnNavigationItemSelectedListener
    so that menu items can be click on
    */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id)
        {
            case R.id.inbox_id:
                Toast.makeText(getApplicationContext(), "Inbox", Toast.LENGTH_LONG).show();

                break;

            case R.id.starred_id:
                Toast.makeText(getApplicationContext(), "Starred", Toast.LENGTH_LONG).show();
                break;

            case R.id.send_id:
                Toast.makeText(getApplicationContext(), "Send", Toast.LENGTH_LONG).show();
                break;

            case R.id.drafts_id:
                Toast.makeText(getApplicationContext(), "Drafts", Toast.LENGTH_LONG).show();
                break;

            case R.id.allmail_id:
                Toast.makeText(getApplicationContext(), "All Email", Toast.LENGTH_LONG).show();
                break;

            case R.id.trash_id:
                Toast.makeText(getApplicationContext(), "Trash", Toast.LENGTH_LONG).show();
                break;

            case R.id.spam_id:
                Toast.makeText(getApplicationContext(), "Spam", Toast.LENGTH_LONG).show();
                break;
        }
        
       
5. Ok agar menu item nya ketika di klik dapat otomatis slide close 
           tambahkan kode dibawah ini sebelum return true;
           
           //close nav drawer
        drawerLayout.closeDrawer(GravityCompat.START);
        
        
6. Selanjutnya tambahkan method onBackPressed
       
       //fungsi method ini untuk ketika di klick back maka otomatis navigationview menutup navigation drawernya
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
            super.onBackPressed();
        }
    }

7. Tambahkan kode style.xml dibawah ini agar stausbarnya trasparant
      <style name="AppTheme.NoActionbar">
        <item name="windowActionBar">false</item>
        <item name="android:windowNoTitle">true</item>
        <item name="android:windowDrawsSystemBarBackgrounds">true</item>
        <item name="android:statusBarColor">@android:color/transparent</item>
    </style>
    
    kemudian pada Androidmanifest di MainActivity tambahkan kode dibawah ini
    
    android:theme="@style/AppTheme.NoActionbar"
    
    
9. Peruabahan Design Toolbar dan navigation drawerlayout
   seperti code dibawah ini
   
   <?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <include layout="@layout/toolbar" />

    <androidx.drawerlayout.widget.DrawerLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/drawer_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_marginTop="?attr/actionBarSize"
        android:fitsSystemWindows="false"
        android:orientation="vertical"
        tools:openDrawer="start">

        <include layout="@layout/activity_main" />

        <com.google.android.material.navigation.NavigationView
            android:id="@+id/navigation_view"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_gravity="start|left"
            android:fitsSystemWindows="true"
            app:headerLayout="@layout/navigation_header"
            app:menu="@menu/navigation_menu" />

    </androidx.drawerlayout.widget.DrawerLayout>
</RelativeLayout>

Result

![1](https://user-images.githubusercontent.com/43386555/64643996-dc8e8f00-d43b-11e9-9d66-7828bffb33c5.jpg)
