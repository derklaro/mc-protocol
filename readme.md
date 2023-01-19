# Snapshot 23w03a (1.19.4), Protocol 115 (1073741939), Release Protocol: 762
## Handshaking (Server -> Client)


## Handshaking (Client -> Server)

#### 0x00 - Client Intention Packet
| Type | Name |
| -------------| -------------|
| int| protocol version|
| String| host name|
| int| port|
| ConnectionProtocol| intention|



## Play (Server -> Client)

#### 0x00 - Bundle Delimiter Packet
| Type | Name |
| -------------| -------------|

#### 0x01 - Add Entity Packet
| Type | Name |
| -------------| -------------|
| int| id|
| UUID| uuid|
| EntityType\<?\>| type|
| double| x|
| double| y|
| double| z|
| int| xa|
| int| ya|
| int| za|
| byte| x rot|
| byte| y rot|
| byte| y head rot|
| int| data|

#### 0x02 - Add Experience Orb Packet
| Type | Name |
| -------------| -------------|
| int| id|
| double| x|
| double| y|
| double| z|
| int| value|

#### 0x03 - Add Player Packet
| Type | Name |
| -------------| -------------|
| int| entity id|
| UUID| player id|
| double| x|
| double| y|
| double| z|
| byte| y rot|
| byte| x rot|

#### 0x04 - Animate Packet
| Type | Name |
| -------------| -------------|
| int| id|
| int| action|

#### 0x05 - Award Stats Packet
| Type | Name |
| -------------| -------------|
| Object2IntMap\<Stat\<?\>\>| stats|

#### 0x06 - Block Changed Ack Packet
| Type | Name |
| -------------| -------------|
| int| sequence|

#### 0x07 - Block Destruction Packet
| Type | Name |
| -------------| -------------|
| int| id|
| BlockPos| pos|
| int| progress|

#### 0x08 - Block Entity Data Packet
| Type | Name |
| -------------| -------------|
| BlockPos| pos|
| BlockEntityType\<?\>| type|
| CompoundTag| tag|

#### 0x09 - Block Event Packet
| Type | Name |
| -------------| -------------|
| BlockPos| pos|
| int| b0|
| int| b1|
| Block| block|

#### 0x0A - Block Update Packet
| Type | Name |
| -------------| -------------|
| BlockPos| pos|
| BlockState| block state|

#### 0x0B - Boss Event Packet
| Type | Name |
| -------------| -------------|
| UUID| id|
| Operation| operation|

#### 0x0C - Change Difficulty Packet
| Type | Name |
| -------------| -------------|
| Difficulty| difficulty|
| boolean| locked|

#### 0x0D - Clear Titles Packet
| Type | Name |
| -------------| -------------|
| boolean| reset times|

#### 0x0E - Command Suggestions Packet
| Type | Name |
| -------------| -------------|
| int| id|
| Suggestions| suggestions|

#### 0x0F - Commands Packet
| Type | Name |
| -------------| -------------|
| int| root index|
| List\<Entry\>| entries|

#### 0x10 - Container Close Packet
| Type | Name |
| -------------| -------------|
| int| container id|

#### 0x11 - Container Set Content Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| int| state id|
| List\<ItemStack\>| items|
| ItemStack| carried item|

#### 0x12 - Container Set Data Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| int| id|
| int| value|

#### 0x13 - Container Set Slot Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| int| state id|
| int| slot|
| ItemStack| item stack|

#### 0x14 - Cooldown Packet
| Type | Name |
| -------------| -------------|
| Item| item|
| int| duration|

#### 0x15 - Custom Chat Completions Packet
| Type | Name |
| -------------| -------------|
| Action| action|
| List\<String\>| entries|

#### 0x16 - Custom Payload Packet
| Type | Name |
| -------------| -------------|
| ResourceLocation| identifier|
| FriendlyByteBuf| data|

#### 0x17 - Delete Chat Packet
| Type | Name |
| -------------| -------------|
| Packed| message signature|

#### 0x18 - Disconnect Packet
| Type | Name |
| -------------| -------------|
| Component| reason|

#### 0x19 - Disguised Chat Packet
| Type | Name |
| -------------| -------------|
| Component| message|
| BoundNetwork| chat type|

#### 0x1A - Entity Event Packet
| Type | Name |
| -------------| -------------|
| int| entity id|
| byte| event id|

#### 0x1B - Explode Packet
| Type | Name |
| -------------| -------------|
| double| x|
| double| y|
| double| z|
| float| power|
| List\<BlockPos\>| to blow|
| float| knockback x|
| float| knockback y|
| float| knockback z|

#### 0x1C - Forget Level Chunk Packet
| Type | Name |
| -------------| -------------|
| int| x|
| int| z|

#### 0x1D - Game Event Packet
| Type | Name |
| -------------| -------------|
| Type| event|
| float| param|

#### 0x1E - Horse Screen Open Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| int| size|
| int| entity id|

#### 0x1F - Hurt Animation Packet
| Type | Name |
| -------------| -------------|
| int| id|
| float| yaw|

#### 0x20 - Initialize Border Packet
| Type | Name |
| -------------| -------------|
| double| new center x|
| double| new center z|
| double| old size|
| double| new size|
| long| lerp time|
| int| new absolute max size|
| int| warning blocks|
| int| warning time|

#### 0x21 - Keep Alive Packet
| Type | Name |
| -------------| -------------|
| long| id|

#### 0x22 - Level Chunk With Light Packet
| Type | Name |
| -------------| -------------|
| int| x|
| int| z|
| ClientboundLevelChunkPacketData| chunk data|
| ClientboundLightUpdatePacketData| light data|

#### 0x23 - Level Event Packet
| Type | Name |
| -------------| -------------|
| int| type|
| BlockPos| pos|
| int| data|
| boolean| global event|

#### 0x24 - Level Particles Packet
| Type | Name |
| -------------| -------------|
| double| x|
| double| y|
| double| z|
| float| x dist|
| float| y dist|
| float| z dist|
| float| max speed|
| int| count|
| boolean| override limiter|
| ParticleOptions| particle|

#### 0x25 - Light Update Packet
| Type | Name |
| -------------| -------------|
| int| x|
| int| z|
| ClientboundLightUpdatePacketData| light data|

#### 0x26 - Login Packet
| Type | Name |
| -------------| -------------|
| int| player id|
| boolean| hardcore|
| GameType| game type|
| GameType| previous game type|
| Set\<ResourceKey\<Level\>\>| levels|
| Frozen| registry holder|
| ResourceKey\<DimensionType\>| dimension type|
| ResourceKey\<Level\>| dimension|
| long| seed|
| int| max players|
| int| chunk radius|
| int| simulation distance|
| boolean| reduced debug info|
| boolean| show death screen|
| boolean| is debug|
| boolean| is flat|
| Optional\<GlobalPos\>| last death location|

#### 0x27 - Map Item Data Packet
| Type | Name |
| -------------| -------------|
| int| map id|
| byte| scale|
| boolean| locked|
| List\<MapDecoration\>| decorations|
| MapPatch| color patch|

#### 0x28 - Merchant Offers Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| MerchantOffers| offers|
| int| villager level|
| int| villager xp|
| boolean| show progress|
| boolean| can restock|

#### 0x29 - Pos
| Type | Name |
| -------------| -------------|
| int| entity id|
| short| xa|
| short| ya|
| short| za|
| byte| y rot|
| byte| x rot|
| boolean| on ground|
| boolean| has rot|
| boolean| has pos|

#### 0x2A - Pos Rot
| Type | Name |
| -------------| -------------|
| int| entity id|
| short| xa|
| short| ya|
| short| za|
| byte| y rot|
| byte| x rot|
| boolean| on ground|
| boolean| has rot|
| boolean| has pos|

#### 0x2B - Rot
| Type | Name |
| -------------| -------------|
| int| entity id|
| short| xa|
| short| ya|
| short| za|
| byte| y rot|
| byte| x rot|
| boolean| on ground|
| boolean| has rot|
| boolean| has pos|

#### 0x2C - Move Vehicle Packet
| Type | Name |
| -------------| -------------|
| double| x|
| double| y|
| double| z|
| float| y rot|
| float| x rot|

#### 0x2D - Open Book Packet
| Type | Name |
| -------------| -------------|
| InteractionHand| hand|

#### 0x2E - Open Screen Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| MenuType\<?\>| type|
| Component| title|

#### 0x2F - Open Sign Editor Packet
| Type | Name |
| -------------| -------------|
| BlockPos| pos|

#### 0x30 - Ping Packet
| Type | Name |
| -------------| -------------|
| int| id|

#### 0x31 - Place Ghost Recipe Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| ResourceLocation| recipe|

#### 0x32 - Player Abilities Packet
| Type | Name |
| -------------| -------------|
| boolean| invulnerable|
| boolean| is flying|
| boolean| can fly|
| boolean| instabuild|
| float| flying speed|
| float| walking speed|

#### 0x33 - Player Chat Packet
| Type | Name |
| -------------| -------------|
| UUID| sender|
| int| index|
| MessageSignature| signature|
| Packed| body|
| Component| unsigned content|
| FilterMask| filter mask|
| BoundNetwork| chat type|

#### 0x34 - Player Combat End Packet
| Type | Name |
| -------------| -------------|
| int| killer id|
| int| duration|

#### 0x35 - Player Combat Enter Packet
| Type | Name |
| -------------| -------------|

#### 0x36 - Player Combat Kill Packet
| Type | Name |
| -------------| -------------|
| int| player id|
| int| killer id|
| Component| message|

#### 0x37 - Player Info Remove Packet
| Type | Name |
| -------------| -------------|
| List\<UUID\>| profile ids|

#### 0x38 - Player Info Update Packet
| Type | Name |
| -------------| -------------|
| EnumSet\<Action\>| actions|
| List\<Entry\>| entries|

#### 0x39 - Player Look At Packet
| Type | Name |
| -------------| -------------|
| double| x|
| double| y|
| double| z|
| int| entity|
| Anchor| from anchor|
| Anchor| to anchor|
| boolean| at entity|

#### 0x3A - Player Position Packet
| Type | Name |
| -------------| -------------|
| double| x|
| double| y|
| double| z|
| float| y rot|
| float| x rot|
| Set\<RelativeMovement\>| relative arguments|
| int| id|
| boolean| dismount vehicle|

#### 0x3B - Recipe Packet
| Type | Name |
| -------------| -------------|
| State| state|
| List\<ResourceLocation\>| recipes|
| List\<ResourceLocation\>| to highlight|
| RecipeBookSettings| book settings|

#### 0x3C - Remove Entities Packet
| Type | Name |
| -------------| -------------|
| IntList| entity ids|

#### 0x3D - Remove Mob Effect Packet
| Type | Name |
| -------------| -------------|
| int| entity id|
| MobEffect| effect|

#### 0x3E - Resource Pack Packet
| Type | Name |
| -------------| -------------|
| String| url|
| String| hash|
| boolean| required|
| Component| prompt|

#### 0x3F - Respawn Packet
| Type | Name |
| -------------| -------------|
| ResourceKey\<DimensionType\>| dimension type|
| ResourceKey\<Level\>| dimension|
| long| seed|
| GameType| player game type|
| GameType| previous player game type|
| boolean| is debug|
| boolean| is flat|
| byte| data to keep|
| Optional\<GlobalPos\>| last death location|

#### 0x40 - Rotate Head Packet
| Type | Name |
| -------------| -------------|
| int| entity id|
| byte| y head rot|

#### 0x41 - Section Blocks Update Packet
| Type | Name |
| -------------| -------------|
| SectionPos| section pos|
| short[]| positions|
| BlockState[]| states|
| boolean| suppress light updates|

#### 0x42 - Select Advancements Tab Packet
| Type | Name |
| -------------| -------------|
| ResourceLocation| tab|

#### 0x43 - Server Data Packet
| Type | Name |
| -------------| -------------|
| Optional\<Component\>| motd|
| Optional\<String\>| icon base64|
| boolean| enforces secure chat|

#### 0x44 - Set Action Bar Text Packet
| Type | Name |
| -------------| -------------|
| Component| text|

#### 0x45 - Set Border Center Packet
| Type | Name |
| -------------| -------------|
| double| new center x|
| double| new center z|

#### 0x46 - Set Border Lerp Size Packet
| Type | Name |
| -------------| -------------|
| double| old size|
| double| new size|
| long| lerp time|

#### 0x47 - Set Border Size Packet
| Type | Name |
| -------------| -------------|
| double| size|

#### 0x48 - Set Border Warning Delay Packet
| Type | Name |
| -------------| -------------|
| int| warning delay|

#### 0x49 - Set Border Warning Distance Packet
| Type | Name |
| -------------| -------------|
| int| warning blocks|

#### 0x4A - Set Camera Packet
| Type | Name |
| -------------| -------------|
| int| camera id|

#### 0x4B - Set Carried Item Packet
| Type | Name |
| -------------| -------------|
| int| slot|

#### 0x4C - Set Chunk Cache Center Packet
| Type | Name |
| -------------| -------------|
| int| x|
| int| z|

#### 0x4D - Set Chunk Cache Radius Packet
| Type | Name |
| -------------| -------------|
| int| radius|

#### 0x4E - Set Default Spawn Position Packet
| Type | Name |
| -------------| -------------|
| BlockPos| pos|
| float| angle|

#### 0x4F - Set Display Objective Packet
| Type | Name |
| -------------| -------------|
| int| slot|
| String| objective name|

#### 0x50 - Set Entity Data Packet
| Type | Name |
| -------------| -------------|
| int| id|
| List\<DataValue\<?\>\>| packed items|

#### 0x51 - Set Entity Link Packet
| Type | Name |
| -------------| -------------|
| int| source id|
| int| dest id|

#### 0x52 - Set Entity Motion Packet
| Type | Name |
| -------------| -------------|
| int| id|
| int| xa|
| int| ya|
| int| za|

#### 0x53 - Set Equipment Packet
| Type | Name |
| -------------| -------------|
| int| entity|
| List\<Pair\<EquipmentSlot, ItemStack\>\>| slots|

#### 0x54 - Set Experience Packet
| Type | Name |
| -------------| -------------|
| float| experience progress|
| int| total experience|
| int| experience level|

#### 0x55 - Set Health Packet
| Type | Name |
| -------------| -------------|
| float| health|
| int| food|
| float| saturation|

#### 0x56 - Set Objective Packet
| Type | Name |
| -------------| -------------|
| String| objective name|
| Component| display name|
| RenderType| render type|
| int| method|

#### 0x57 - Set Passengers Packet
| Type | Name |
| -------------| -------------|
| int| vehicle|
| int[]| passengers|

#### 0x58 - Set Player Team Packet
| Type | Name |
| -------------| -------------|
| int| method|
| String| name|
| Collection\<String\>| players|
| Optional\<Parameters\>| parameters|

#### 0x59 - Set Score Packet
| Type | Name |
| -------------| -------------|
| String| owner|
| String| objective name|
| int| score|
| Method| method|

#### 0x5A - Set Simulation Distance Packet
| Type | Name |
| -------------| -------------|
| int| simulation distance|

#### 0x5B - Set Subtitle Text Packet
| Type | Name |
| -------------| -------------|
| Component| text|

#### 0x5C - Set Time Packet
| Type | Name |
| -------------| -------------|
| long| game time|
| long| day time|

#### 0x5D - Set Title Text Packet
| Type | Name |
| -------------| -------------|
| Component| text|

#### 0x5E - Set Titles Animation Packet
| Type | Name |
| -------------| -------------|
| int| fade in|
| int| stay|
| int| fade out|

#### 0x5F - Sound Entity Packet
| Type | Name |
| -------------| -------------|
| Holder\<SoundEvent\>| sound|
| SoundSource| source|
| int| id|
| float| volume|
| float| pitch|
| long| seed|

#### 0x60 - Sound Packet
| Type | Name |
| -------------| -------------|
| Holder\<SoundEvent\>| sound|
| SoundSource| source|
| int| x|
| int| y|
| int| z|
| float| volume|
| float| pitch|
| long| seed|

#### 0x61 - Stop Sound Packet
| Type | Name |
| -------------| -------------|
| ResourceLocation| name|
| SoundSource| source|

#### 0x62 - System Chat Packet
| Type | Name |
| -------------| -------------|
| Component| content|
| boolean| overlay|

#### 0x63 - Tab List Packet
| Type | Name |
| -------------| -------------|
| Component| header|
| Component| footer|

#### 0x64 - Tag Query Packet
| Type | Name |
| -------------| -------------|
| int| transaction id|
| CompoundTag| tag|

#### 0x65 - Take Item Entity Packet
| Type | Name |
| -------------| -------------|
| int| item id|
| int| player id|
| int| amount|

#### 0x66 - Teleport Entity Packet
| Type | Name |
| -------------| -------------|
| int| id|
| double| x|
| double| y|
| double| z|
| byte| y rot|
| byte| x rot|
| boolean| on ground|

#### 0x67 - Update Advancements Packet
| Type | Name |
| -------------| -------------|
| boolean| reset|
| Map\<ResourceLocation, Builder\>| added|
| Set\<ResourceLocation\>| removed|
| Map\<ResourceLocation, AdvancementProgress\>| progress|

#### 0x68 - Update Attributes Packet
| Type | Name |
| -------------| -------------|
| int| entity id|
| List\<AttributeSnapshot\>| attributes|

#### 0x69 - Update Enabled Features Packet
| Type | Name |
| -------------| -------------|
| Set\<ResourceLocation\>| features|

#### 0x6A - Update Mob Effect Packet
| Type | Name |
| -------------| -------------|
| int| entity id|
| MobEffect| effect|
| byte| effect amplifier|
| int| effect duration ticks|
| byte| flags|
| FactorData| factor data|

#### 0x6B - Update Recipes Packet
| Type | Name |
| -------------| -------------|
| List\<Recipe\<?\>\>| recipes|

#### 0x6C - Update Tags Packet
| Type | Name |
| -------------| -------------|
| Map\<ResourceKey\<? extends Registry\<?\>\>, NetworkPayload\>| tags|


## Play (Client -> Server)

#### 0x00 - Accept Teleportation Packet
| Type | Name |
| -------------| -------------|
| int| id|

#### 0x01 - Block Entity Tag Query
| Type | Name |
| -------------| -------------|
| int| transaction id|
| BlockPos| pos|

#### 0x02 - Change Difficulty Packet
| Type | Name |
| -------------| -------------|
| Difficulty| difficulty|

#### 0x03 - Chat Ack Packet
| Type | Name |
| -------------| -------------|
| int| offset|

#### 0x04 - Chat Command Packet
| Type | Name |
| -------------| -------------|
| String| command|
| Instant| time stamp|
| long| salt|
| ArgumentSignatures| argument signatures|
| Update| last seen messages|

#### 0x05 - Chat Packet
| Type | Name |
| -------------| -------------|
| String| message|
| Instant| time stamp|
| long| salt|
| MessageSignature| signature|
| Update| last seen messages|

#### 0x06 - Chat Session Update Packet
| Type | Name |
| -------------| -------------|
| Data| chat session|

#### 0x07 - Client Command Packet
| Type | Name |
| -------------| -------------|
| Action| action|

#### 0x08 - Client Information Packet
| Type | Name |
| -------------| -------------|
| String| language|
| int| view distance|
| ChatVisiblity| chat visibility|
| boolean| chat colors|
| int| model customisation|
| HumanoidArm| main hand|
| boolean| text filtering enabled|
| boolean| allows listing|

#### 0x09 - Command Suggestion Packet
| Type | Name |
| -------------| -------------|
| int| id|
| String| command|

#### 0x0A - Container Button Click Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| int| button id|

#### 0x0B - Container Click Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| int| state id|
| int| slot num|
| int| button num|
| ClickType| click type|
| ItemStack| carried item|
| Int2ObjectMap\<ItemStack\>| changed slots|

#### 0x0C - Container Close Packet
| Type | Name |
| -------------| -------------|
| int| container id|

#### 0x0D - Custom Payload Packet
| Type | Name |
| -------------| -------------|
| ResourceLocation| identifier|
| FriendlyByteBuf| data|

#### 0x0E - Edit Book Packet
| Type | Name |
| -------------| -------------|
| int| slot|
| List\<String\>| pages|
| Optional\<String\>| title|

#### 0x0F - Entity Tag Query
| Type | Name |
| -------------| -------------|
| int| transaction id|
| int| entity id|

#### 0x10 - Interact Packet
| Type | Name |
| -------------| -------------|
| int| entity id|
| Action| action|
| boolean| using secondary action|

#### 0x11 - Jigsaw Generate Packet
| Type | Name |
| -------------| -------------|
| BlockPos| pos|
| int| levels|
| boolean| keep jigsaws|

#### 0x12 - Keep Alive Packet
| Type | Name |
| -------------| -------------|
| long| id|

#### 0x13 - Lock Difficulty Packet
| Type | Name |
| -------------| -------------|
| boolean| locked|

#### 0x14 - Pos
| Type | Name |
| -------------| -------------|
| double| x|
| double| y|
| double| z|
| float| y rot|
| float| x rot|
| boolean| on ground|
| boolean| has pos|
| boolean| has rot|

#### 0x15 - Pos Rot
| Type | Name |
| -------------| -------------|
| double| x|
| double| y|
| double| z|
| float| y rot|
| float| x rot|
| boolean| on ground|
| boolean| has pos|
| boolean| has rot|

#### 0x16 - Rot
| Type | Name |
| -------------| -------------|
| double| x|
| double| y|
| double| z|
| float| y rot|
| float| x rot|
| boolean| on ground|
| boolean| has pos|
| boolean| has rot|

#### 0x17 - Status Only
| Type | Name |
| -------------| -------------|
| double| x|
| double| y|
| double| z|
| float| y rot|
| float| x rot|
| boolean| on ground|
| boolean| has pos|
| boolean| has rot|

#### 0x18 - Move Vehicle Packet
| Type | Name |
| -------------| -------------|
| double| x|
| double| y|
| double| z|
| float| y rot|
| float| x rot|

#### 0x19 - Paddle Boat Packet
| Type | Name |
| -------------| -------------|
| boolean| left|
| boolean| right|

#### 0x1A - Pick Item Packet
| Type | Name |
| -------------| -------------|
| int| slot|

#### 0x1B - Place Recipe Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| ResourceLocation| recipe|
| boolean| shift down|

#### 0x1C - Player Abilities Packet
| Type | Name |
| -------------| -------------|
| boolean| is flying|

#### 0x1D - Player Action Packet
| Type | Name |
| -------------| -------------|
| BlockPos| pos|
| Direction| direction|
| Action| action|
| int| sequence|

#### 0x1E - Player Command Packet
| Type | Name |
| -------------| -------------|
| int| id|
| Action| action|
| int| data|

#### 0x1F - Player Input Packet
| Type | Name |
| -------------| -------------|
| float| xxa|
| float| zza|
| boolean| is jumping|
| boolean| is shift key down|

#### 0x20 - Pong Packet
| Type | Name |
| -------------| -------------|
| int| id|

#### 0x21 - Recipe Book Change Settings Packet
| Type | Name |
| -------------| -------------|
| RecipeBookType| book type|
| boolean| is open|
| boolean| is filtering|

#### 0x22 - Recipe Book Seen Recipe Packet
| Type | Name |
| -------------| -------------|
| ResourceLocation| recipe|

#### 0x23 - Rename Item Packet
| Type | Name |
| -------------| -------------|
| String| name|

#### 0x24 - Resource Pack Packet
| Type | Name |
| -------------| -------------|
| Action| action|

#### 0x25 - Seen Advancements Packet
| Type | Name |
| -------------| -------------|
| Action| action|
| ResourceLocation| tab|

#### 0x26 - Select Trade Packet
| Type | Name |
| -------------| -------------|
| int| item|

#### 0x27 - Set Beacon Packet
| Type | Name |
| -------------| -------------|
| Optional\<MobEffect\>| primary|
| Optional\<MobEffect\>| secondary|

#### 0x28 - Set Carried Item Packet
| Type | Name |
| -------------| -------------|
| int| slot|

#### 0x29 - Set Command Block Packet
| Type | Name |
| -------------| -------------|
| BlockPos| pos|
| String| command|
| boolean| track output|
| boolean| conditional|
| boolean| automatic|
| Mode| mode|

#### 0x2A - Set Command Minecart Packet
| Type | Name |
| -------------| -------------|
| int| entity|
| String| command|
| boolean| track output|

#### 0x2B - Set Creative Mode Slot Packet
| Type | Name |
| -------------| -------------|
| int| slot num|
| ItemStack| item stack|

#### 0x2C - Set Jigsaw Block Packet
| Type | Name |
| -------------| -------------|
| BlockPos| pos|
| ResourceLocation| name|
| ResourceLocation| target|
| ResourceLocation| pool|
| String| final state|
| JointType| joint|

#### 0x2D - Set Structure Block Packet
| Type | Name |
| -------------| -------------|
| BlockPos| pos|
| UpdateType| update type|
| StructureMode| mode|
| String| name|
| BlockPos| offset|
| Vec3i| size|
| Mirror| mirror|
| Rotation| rotation|
| String| data|
| boolean| ignore entities|
| boolean| show air|
| boolean| show bounding box|
| float| integrity|
| long| seed|

#### 0x2E - Sign Update Packet
| Type | Name |
| -------------| -------------|
| BlockPos| pos|
| String[]| lines|

#### 0x2F - Swing Packet
| Type | Name |
| -------------| -------------|
| InteractionHand| hand|

#### 0x30 - Teleport To Entity Packet
| Type | Name |
| -------------| -------------|
| UUID| uuid|

#### 0x31 - Use Item On Packet
| Type | Name |
| -------------| -------------|
| BlockHitResult| block hit|
| InteractionHand| hand|
| int| sequence|

#### 0x32 - Use Item Packet
| Type | Name |
| -------------| -------------|
| InteractionHand| hand|
| int| sequence|



## Status (Server -> Client)

#### 0x00 - Status Response Packet
| Type | Name |
| -------------| -------------|
| ServerStatus| status|

#### 0x01 - Pong Response Packet
| Type | Name |
| -------------| -------------|
| long| time|


## Status (Client -> Server)

#### 0x00 - Status Request Packet
| Type | Name |
| -------------| -------------|

#### 0x01 - Ping Request Packet
| Type | Name |
| -------------| -------------|
| long| time|



## Login (Server -> Client)

#### 0x00 - Login Disconnect Packet
| Type | Name |
| -------------| -------------|
| Component| reason|

#### 0x01 - Hello Packet
| Type | Name |
| -------------| -------------|
| String| server id|
| byte[]| public key|
| byte[]| challenge|

#### 0x02 - Game Profile Packet
| Type | Name |
| -------------| -------------|
| GameProfile| game profile|

#### 0x03 - Login Compression Packet
| Type | Name |
| -------------| -------------|
| int| compression threshold|

#### 0x04 - Custom Query Packet
| Type | Name |
| -------------| -------------|
| int| transaction id|
| ResourceLocation| identifier|
| FriendlyByteBuf| data|


## Login (Client -> Server)

#### 0x00 - Hello Packet
| Type | Name |
| -------------| -------------|
| String| name|
| Optional\<UUID\>| profile id|

#### 0x01 - Key Packet
| Type | Name |
| -------------| -------------|
| byte[]| keybytes|
| byte[]| encrypted challenge|

#### 0x02 - Custom Query Packet
| Type | Name |
| -------------| -------------|
| int| transaction id|
| FriendlyByteBuf| data|



