Feature: Cari Google
  Scenario: Saya ingin menggunakan fitur pencarian di google
    Given saya Buka browser
    And Buka situs web Google
    And Terletak di situs web google
    When saya mencari "Rahma Syndu Grananta"
    Then Menampilkan hasil yang terkait dengan "Rahma Syndu Grananta"