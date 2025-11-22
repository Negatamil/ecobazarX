# EcoBazaarX API Endpoints

## 🌱 Carbon Footprint Aware Shopping Assistant Backend

### Health Check
- `GET /api/health` - Check if backend is running
- `GET /api/info` - Get application information

### 👤 Users
- `POST /users/register` - Register new user
- `POST /users/login` - User login
- `GET /users` - Get all users (Admin only)

### 🛍️ Products
- `POST /products/add` - Add new product
- `PUT /products/update` - Update product
- `GET /products` - Get all products
- `GET /products/{id}` - Get product by ID
- `GET /products/category/{categoryId}` - Get products by category
- `GET /products/carbon-footprint/asc` - Get products sorted by carbon footprint (low to high)
- `GET /products/carbon-footprint/desc` - Get products sorted by carbon footprint (high to low)

### 📦 Categories
- `POST /categories/add` - Add new category
- `PUT /categories/update` - Update category
- `GET /categories` - Get all categories
- `GET /categories/{id}` - Get category by ID

### 🌍 Carbon Footprints
- `POST /carbon/add` - Add carbon footprint for product
- `PUT /carbon/update` - Update carbon footprint
- `GET /carbon` - Get all carbon footprints
- `GET /carbon/product/{productId}` - Get carbon footprint by product

### 🛒 Orders
- `POST /orders/place` - Place new order
- `GET /orders/user/{userId}` - Get order history for user
- `GET /orders/{orderId}` - Get order by ID

### 💡 Recommendations
- `POST /recommendations/add` - Add recommendation for user
- `GET /recommendations/user/{userId}` - Get recommendations by user
- `GET /recommendations` - Get all recommendations

## Sample Request Bodies

### Register User
```json
{
    "name": "John Doe",
    "email": "john@example.com",
    "password": "password123",
    "role": "CUSTOMER"
}
```

### Add Product
```json
{
    "name": "Eco-Friendly T-Shirt",
    "price": 25.99,
    "description": "100% organic cotton t-shirt",
    "imageUrl": "https://example.com/tshirt.jpg",
    "vendor": {"userId": 1},
    "category": {"categoryId": 1}
}
```

### Place Order
```json
{
    "userId": 1,
    "items": [
        {
            "productId": 1,
            "quantity": 2
        },
        {
            "productId": 2,
            "quantity": 1
        }
    ]
}
```

### Add Carbon Footprint
```json
{
    "product": {"productId": 1},
    "co2Emission": 2.5,
    "energyUsed": 15.0,
    "waterUsed": 100.0
}
```

### Add Category
```json
{
    "categoryName": "Clothing",
    "description": "Sustainable clothing items"
}
```

### Add Recommendation
```json
{
    "user": {"userId": 1},
    "recommendedProduct": {"productId": 2},
    "reason": "Lower carbon footprint alternative",
    "ecoScore": 8.5
}
```