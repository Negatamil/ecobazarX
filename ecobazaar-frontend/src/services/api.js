import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080';

const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

// Request interceptor for auth
api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('authToken');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => Promise.reject(error)
);

// Response interceptor for error handling
api.interceptors.response.use(
  (response) => response,
  (error) => {
    if (error.response?.status === 401) {
      localStorage.removeItem('authToken');
      window.location.href = '/login';
    }
    return Promise.reject(error);
  }
);

// Auth API
export const authAPI = {
  register: (userData) => api.post('/users/register', userData),
  login: (credentials) => api.post('/users/login', credentials),
  getUsers: () => api.get('/users'),
};

// Products API
export const productsAPI = {
  getAll: () => api.get('/products'),
  getById: (id) => api.get(`/products/${id}`),
  create: (product) => api.post('/products/add', product),
  update: (product) => api.put('/products/update', product),
  getByCategory: (categoryId) => api.get(`/products/category/${categoryId}`),
  getByCarbonFootprintAsc: () => api.get('/products/carbon-footprint/asc'),
  getByCarbonFootprintDesc: () => api.get('/products/carbon-footprint/desc'),
};

// Categories API
export const categoriesAPI = {
  getAll: () => api.get('/categories'),
  getById: (id) => api.get(`/categories/${id}`),
  create: (category) => api.post('/categories/add', category),
  update: (category) => api.put('/categories/update', category),
};

// Orders API
export const ordersAPI = {
  place: (orderData) => api.post('/orders/place', orderData),
  getByUser: (userId) => api.get(`/orders/user/${userId}`),
  getById: (orderId) => api.get(`/orders/${orderId}`),
};

// Carbon Footprint API
export const carbonAPI = {
  getAll: () => api.get('/carbon'),
  create: (carbonData) => api.post('/carbon/add', carbonData),
  update: (carbonData) => api.put('/carbon/update', carbonData),
  getByProduct: (productId) => api.get(`/carbon/product/${productId}`),
};

// Recommendations API
export const recommendationsAPI = {
  getAll: () => api.get('/recommendations'),
  getByUser: (userId) => api.get(`/recommendations/user/${userId}`),
  create: (recommendation) => api.post('/recommendations/add', recommendation),
};

export default api;