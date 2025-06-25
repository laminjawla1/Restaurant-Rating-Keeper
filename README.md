flowchart TD
A[Start] --> B1[Advance UI]
A --> B2[Basic UI]

    B1 --> C1[Issue command & args]
    C1 --> D1[Parse Command]
    
    B2 --> D1

    D1 --> E[Dispatcher]
    E --> F[Service]
    F --> G[Repository]
    
    G --> H1[Models]
    G --> H2[JSON Database]
    H2 --> I[View]
    H1 --> I

    I --> Z[END]
