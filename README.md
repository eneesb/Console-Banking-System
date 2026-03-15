# 🏦 Console Banking System

A simple console-based banking application built with Java, featuring account management, transactions, and session-based login.

---

## ✨ Features

- 🔐 **Secure Login** — IBAN and password based authentication with 3-attempt lockout
- 👤 **Account Creation** — Create new accounts with unique IBAN validation
- ➕ **Deposit** — Add funds to your account with input validation
- ➖ **Withdrawal** — Withdraw funds with insufficient balance protection
- 🔄 **Transfer** — Transfer money between accounts by IBAN
- 📋 **Transaction History** — View all past transactions with timestamps
- 💰 **Balance Inquiry** — Check current account balance anytime

---

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Core programming language |
| OOP | Object-Oriented design with 5 classes |
| Enum | Transaction type classification |
| Java Time API | Timestamp for each transaction |
| Exception Handling | Input validation and error management |

---

## 🏗️ Project Structure

```
console-banking-system/
│
├── Main.java         # Entry point, menus, and user interaction
├── Banka.java        # Bank class — manages all accounts
├── Hesap.java        # Account class — handles transactions
├── İslem.java        # Transaction record with timestamp
└── İslemTuru.java    # Enum — YATIRMA, CEKME, TRANSFER
```

---

## ⚙️ Installation & Setup

### Prerequisites

- Java 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse) or terminal

### 1. Clone the repository

```bash
git clone https://github.com/eneesb/Console-Banking-System.git
cd Console-Banking-System
```

### 2. Compile

```bash
javac *.java
```

### 3. Run

```bash
java Main
```

---

## 🚀 How It Works

```
--- ANA MENÜ ---
1- Giriş Yap
2- Hesap Oluştur
0- Çıkış

  ↓ Login with IBAN + Password (max 3 attempts)

--- İŞLEM MENÜ ---
1- Para Yatır
2- Para Çek
3- Transfer Yap
4- İşlem Geçmişi
5- Bakiye Görüntüle
0- Çıkış Yap
```

---

## 📐 Class Design

| Class | Responsibility |
|-------|---------------|
| `Main` | UI, menus, user input handling |
| `Banka` | Stores all accounts, handles login & IBAN lookup |
| `Hesap` | Account logic — deposit, withdraw, transfer, history |
| `İslem` | Immutable transaction record with type, amount, date |
| `İslemTuru` | Enum with values: `YATIRMA`, `CEKME`, `TRANSFER` |

---

## 🚀 Future Improvements

- [ ] Decimal amount support (e.g. 12.50 ₺)
- [ ] Persistent data storage (file or database)
- [ ] Password hashing for security
- [ ] Account deletion
- [ ] Transfer history shown on both sender and receiver
- [ ] GUI with JavaFX or Swing
- [ ] Multi-currency support

---

## 👨‍💻 Author

**Enes B.** — *Software Engineering Student*

> Built as a personal learning project to practice Java OOP concepts including encapsulation, exception handling, and class design.
