# Release 1.19.3, Protocol 761
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

#### 0x00 - Add Entity Packet
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

#### 0x01 - Add Experience Orb Packet
| Type | Name |
| -------------| -------------|
| int| id|
| double| x|
| double| y|
| double| z|
| int| value|

#### 0x02 - Add Player Packet
| Type | Name |
| -------------| -------------|
| int| entity id|
| UUID| player id|
| double| x|
| double| y|
| double| z|
| byte| y rot|
| byte| x rot|

#### 0x03 - Animate Packet
| Type | Name |
| -------------| -------------|
| int| id|
| int| action|

#### 0x04 - Award Stats Packet
| Type | Name |
| -------------| -------------|
| Object2IntMap\<Stat\<?\>\>| stats|

#### 0x05 - Block Changed Ack Packet
| Type | Name |
| -------------| -------------|
| int| sequence|

#### 0x06 - Block Destruction Packet
| Type | Name |
| -------------| -------------|
| int| id|
| BlockPos| pos|
| int| progress|

#### 0x07 - Block Entity Data Packet
| Type | Name |
| -------------| -------------|
| BlockPos| pos|
| BlockEntityType\<?\>| type|
| CompoundTag| tag|

#### 0x08 - Block Event Packet
| Type | Name |
| -------------| -------------|
| BlockPos| pos|
| int| b0|
| int| b1|
| Block| block|

#### 0x09 - Block Update Packet
| Type | Name |
| -------------| -------------|
| BlockPos| pos|
| BlockState| block state|

#### 0x0A - Boss Event Packet
| Type | Name |
| -------------| -------------|
| UUID| id|
| Operation| operation|

#### 0x0B - Change Difficulty Packet
| Type | Name |
| -------------| -------------|
| Difficulty| difficulty|
| boolean| locked|

#### 0x0C - Clear Titles Packet
| Type | Name |
| -------------| -------------|
| boolean| reset times|

#### 0x0D - Command Suggestions Packet
| Type | Name |
| -------------| -------------|
| int| id|
| Suggestions| suggestions|

#### 0x0E - Commands Packet
| Type | Name |
| -------------| -------------|
| int| root index|
| List\<Entry\>| entries|

#### 0x0F - Container Close Packet
| Type | Name |
| -------------| -------------|
| int| container id|

#### 0x10 - Container Set Content Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| int| state id|
| List\<ItemStack\>| items|
| ItemStack| carried item|

#### 0x11 - Container Set Data Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| int| id|
| int| value|

#### 0x12 - Container Set Slot Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| int| state id|
| int| slot|
| ItemStack| item stack|

#### 0x13 - Cooldown Packet
| Type | Name |
| -------------| -------------|
| Item| item|
| int| duration|

#### 0x14 - Custom Chat Completions Packet
| Type | Name |
| -------------| -------------|
| Action| action|
| List\<String\>| entries|

#### 0x15 - Custom Payload Packet
| Type | Name |
| -------------| -------------|
| ResourceLocation| identifier|
| FriendlyByteBuf| data|

#### 0x16 - Delete Chat Packet
| Type | Name |
| -------------| -------------|
| Packed| message signature|

#### 0x17 - Disconnect Packet
| Type | Name |
| -------------| -------------|
| Component| reason|

#### 0x18 - Disguised Chat Packet
| Type | Name |
| -------------| -------------|
| Component| message|
| BoundNetwork| chat type|

#### 0x19 - Entity Event Packet
| Type | Name |
| -------------| -------------|
| int| entity id|
| byte| event id|

#### 0x1A - Explode Packet
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

#### 0x1B - Forget Level Chunk Packet
| Type | Name |
| -------------| -------------|
| int| x|
| int| z|

#### 0x1C - Game Event Packet
| Type | Name |
| -------------| -------------|
| Type| event|
| float| param|

#### 0x1D - Horse Screen Open Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| int| size|
| int| entity id|

#### 0x1E - Initialize Border Packet
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

#### 0x1F - Keep Alive Packet
| Type | Name |
| -------------| -------------|
| long| id|

#### 0x20 - Level Chunk With Light Packet
| Type | Name |
| -------------| -------------|
| int| x|
| int| z|
| ClientboundLevelChunkPacketData| chunk data|
| ClientboundLightUpdatePacketData| light data|

#### 0x21 - Level Event Packet
| Type | Name |
| -------------| -------------|
| int| type|
| BlockPos| pos|
| int| data|
| boolean| global event|

#### 0x22 - Level Particles Packet
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

#### 0x23 - Light Update Packet
| Type | Name |
| -------------| -------------|
| int| x|
| int| z|
| ClientboundLightUpdatePacketData| light data|

#### 0x24 - Login Packet
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

#### 0x25 - Map Item Data Packet
| Type | Name |
| -------------| -------------|
| int| map id|
| byte| scale|
| boolean| locked|
| List\<MapDecoration\>| decorations|
| MapPatch| color patch|

#### 0x26 - Merchant Offers Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| MerchantOffers| offers|
| int| villager level|
| int| villager xp|
| boolean| show progress|
| boolean| can restock|

#### 0x27 - Pos
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

#### 0x28 - Pos Rot
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

#### 0x29 - Rot
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

#### 0x2A - Move Vehicle Packet
| Type | Name |
| -------------| -------------|
| double| x|
| double| y|
| double| z|
| float| y rot|
| float| x rot|

#### 0x2B - Open Book Packet
| Type | Name |
| -------------| -------------|
| InteractionHand| hand|

#### 0x2C - Open Screen Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| MenuType\<?\>| type|
| Component| title|

#### 0x2D - Open Sign Editor Packet
| Type | Name |
| -------------| -------------|
| BlockPos| pos|

#### 0x2E - Ping Packet
| Type | Name |
| -------------| -------------|
| int| id|

#### 0x2F - Place Ghost Recipe Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| ResourceLocation| recipe|

#### 0x30 - Player Abilities Packet
| Type | Name |
| -------------| -------------|
| boolean| invulnerable|
| boolean| is flying|
| boolean| can fly|
| boolean| instabuild|
| float| flying speed|
| float| walking speed|

#### 0x31 - Player Chat Packet
| Type | Name |
| -------------| -------------|
| UUID| sender|
| int| index|
| MessageSignature| signature|
| Packed| body|
| Component| unsigned content|
| FilterMask| filter mask|
| BoundNetwork| chat type|

#### 0x32 - Player Combat End Packet
| Type | Name |
| -------------| -------------|
| int| killer id|
| int| duration|

#### 0x33 - Player Combat Enter Packet
| Type | Name |
| -------------| -------------|

#### 0x34 - Player Combat Kill Packet
| Type | Name |
| -------------| -------------|
| int| player id|
| int| killer id|
| Component| message|

#### 0x35 - Player Info Remove Packet
| Type | Name |
| -------------| -------------|
| List\<UUID\>| profile ids|

#### 0x36 - Player Info Update Packet
| Type | Name |
| -------------| -------------|
| EnumSet\<Action\>| actions|
| List\<Entry\>| entries|

#### 0x37 - Player Look At Packet
| Type | Name |
| -------------| -------------|
| double| x|
| double| y|
| double| z|
| int| entity|
| Anchor| from anchor|
| Anchor| to anchor|
| boolean| at entity|

#### 0x38 - Player Position Packet
| Type | Name |
| -------------| -------------|
| double| x|
| double| y|
| double| z|
| float| y rot|
| float| x rot|
| Set\<RelativeArgument\>| relative arguments|
| int| id|
| boolean| dismount vehicle|

#### 0x39 - Recipe Packet
| Type | Name |
| -------------| -------------|
| State| state|
| List\<ResourceLocation\>| recipes|
| List\<ResourceLocation\>| to highlight|
| RecipeBookSettings| book settings|

#### 0x3A - Remove Entities Packet
| Type | Name |
| -------------| -------------|
| IntList| entity ids|

#### 0x3B - Remove Mob Effect Packet
| Type | Name |
| -------------| -------------|
| int| entity id|
| MobEffect| effect|

#### 0x3C - Resource Pack Packet
| Type | Name |
| -------------| -------------|
| String| url|
| String| hash|
| boolean| required|
| Component| prompt|

#### 0x3D - Respawn Packet
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

#### 0x3E - Rotate Head Packet
| Type | Name |
| -------------| -------------|
| int| entity id|
| byte| y head rot|

#### 0x3F - Section Blocks Update Packet
| Type | Name |
| -------------| -------------|
| SectionPos| section pos|
| short[]| positions|
| BlockState[]| states|
| boolean| suppress light updates|

#### 0x40 - Select Advancements Tab Packet
| Type | Name |
| -------------| -------------|
| ResourceLocation| tab|

#### 0x41 - Server Data Packet
| Type | Name |
| -------------| -------------|
| Optional\<Component\>| motd|
| Optional\<String\>| icon base64|
| boolean| enforces secure chat|

#### 0x42 - Set Action Bar Text Packet
| Type | Name |
| -------------| -------------|
| Component| text|

#### 0x43 - Set Border Center Packet
| Type | Name |
| -------------| -------------|
| double| new center x|
| double| new center z|

#### 0x44 - Set Border Lerp Size Packet
| Type | Name |
| -------------| -------------|
| double| old size|
| double| new size|
| long| lerp time|

#### 0x45 - Set Border Size Packet
| Type | Name |
| -------------| -------------|
| double| size|

#### 0x46 - Set Border Warning Delay Packet
| Type | Name |
| -------------| -------------|
| int| warning delay|

#### 0x47 - Set Border Warning Distance Packet
| Type | Name |
| -------------| -------------|
| int| warning blocks|

#### 0x48 - Set Camera Packet
| Type | Name |
| -------------| -------------|
| int| camera id|

#### 0x49 - Set Carried Item Packet
| Type | Name |
| -------------| -------------|
| int| slot|

#### 0x4A - Set Chunk Cache Center Packet
| Type | Name |
| -------------| -------------|
| int| x|
| int| z|

#### 0x4B - Set Chunk Cache Radius Packet
| Type | Name |
| -------------| -------------|
| int| radius|

#### 0x4C - Set Default Spawn Position Packet
| Type | Name |
| -------------| -------------|
| BlockPos| pos|
| float| angle|

#### 0x4D - Set Display Objective Packet
| Type | Name |
| -------------| -------------|
| int| slot|
| String| objective name|

#### 0x4E - Set Entity Data Packet
| Type | Name |
| -------------| -------------|
| int| id|
| List\<DataValue\<?\>\>| packed items|

#### 0x4F - Set Entity Link Packet
| Type | Name |
| -------------| -------------|
| int| source id|
| int| dest id|

#### 0x50 - Set Entity Motion Packet
| Type | Name |
| -------------| -------------|
| int| id|
| int| xa|
| int| ya|
| int| za|

#### 0x51 - Set Equipment Packet
| Type | Name |
| -------------| -------------|
| int| entity|
| List\<Pair\<EquipmentSlot, ItemStack\>\>| slots|

#### 0x52 - Set Experience Packet
| Type | Name |
| -------------| -------------|
| float| experience progress|
| int| total experience|
| int| experience level|

#### 0x53 - Set Health Packet
| Type | Name |
| -------------| -------------|
| float| health|
| int| food|
| float| saturation|

#### 0x54 - Set Objective Packet
| Type | Name |
| -------------| -------------|
| String| objective name|
| Component| display name|
| RenderType| render type|
| int| method|

#### 0x55 - Set Passengers Packet
| Type | Name |
| -------------| -------------|
| int| vehicle|
| int[]| passengers|

#### 0x56 - Set Player Team Packet
| Type | Name |
| -------------| -------------|
| int| method|
| String| name|
| Collection\<String\>| players|
| Optional\<Parameters\>| parameters|

#### 0x57 - Set Score Packet
| Type | Name |
| -------------| -------------|
| String| owner|
| String| objective name|
| int| score|
| Method| method|

#### 0x58 - Set Simulation Distance Packet
| Type | Name |
| -------------| -------------|
| int| simulation distance|

#### 0x59 - Set Subtitle Text Packet
| Type | Name |
| -------------| -------------|
| Component| text|

#### 0x5A - Set Time Packet
| Type | Name |
| -------------| -------------|
| long| game time|
| long| day time|

#### 0x5B - Set Title Text Packet
| Type | Name |
| -------------| -------------|
| Component| text|

#### 0x5C - Set Titles Animation Packet
| Type | Name |
| -------------| -------------|
| int| fade in|
| int| stay|
| int| fade out|

#### 0x5D - Sound Entity Packet
| Type | Name |
| -------------| -------------|
| Holder\<SoundEvent\>| sound|
| SoundSource| source|
| int| id|
| float| volume|
| float| pitch|
| long| seed|

#### 0x5E - Sound Packet
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

#### 0x5F - Stop Sound Packet
| Type | Name |
| -------------| -------------|
| ResourceLocation| name|
| SoundSource| source|

#### 0x60 - System Chat Packet
| Type | Name |
| -------------| -------------|
| Component| content|
| boolean| overlay|

#### 0x61 - Tab List Packet
| Type | Name |
| -------------| -------------|
| Component| header|
| Component| footer|

#### 0x62 - Tag Query Packet
| Type | Name |
| -------------| -------------|
| int| transaction id|
| CompoundTag| tag|

#### 0x63 - Take Item Entity Packet
| Type | Name |
| -------------| -------------|
| int| item id|
| int| player id|
| int| amount|

#### 0x64 - Teleport Entity Packet
| Type | Name |
| -------------| -------------|
| int| id|
| double| x|
| double| y|
| double| z|
| byte| y rot|
| byte| x rot|
| boolean| on ground|

#### 0x65 - Update Advancements Packet
| Type | Name |
| -------------| -------------|
| boolean| reset|
| Map\<ResourceLocation, Builder\>| added|
| Set\<ResourceLocation\>| removed|
| Map\<ResourceLocation, AdvancementProgress\>| progress|

#### 0x66 - Update Attributes Packet
| Type | Name |
| -------------| -------------|
| int| entity id|
| List\<AttributeSnapshot\>| attributes|

#### 0x67 - Update Enabled Features Packet
| Type | Name |
| -------------| -------------|
| Set\<ResourceLocation\>| features|

#### 0x68 - Update Mob Effect Packet
| Type | Name |
| -------------| -------------|
| int| entity id|
| MobEffect| effect|
| byte| effect amplifier|
| int| effect duration ticks|
| byte| flags|
| FactorData| factor data|

#### 0x69 - Update Recipes Packet
| Type | Name |
| -------------| -------------|
| List\<Recipe\<?\>\>| recipes|

#### 0x6A - Update Tags Packet
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

#### 0x06 - Client Command Packet
| Type | Name |
| -------------| -------------|
| Action| action|

#### 0x07 - Client Information Packet
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

#### 0x08 - Command Suggestion Packet
| Type | Name |
| -------------| -------------|
| int| id|
| String| command|

#### 0x09 - Container Button Click Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| int| button id|

#### 0x0A - Container Click Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| int| state id|
| int| slot num|
| int| button num|
| ClickType| click type|
| ItemStack| carried item|
| Int2ObjectMap\<ItemStack\>| changed slots|

#### 0x0B - Container Close Packet
| Type | Name |
| -------------| -------------|
| int| container id|

#### 0x0C - Custom Payload Packet
| Type | Name |
| -------------| -------------|
| ResourceLocation| identifier|
| FriendlyByteBuf| data|

#### 0x0D - Edit Book Packet
| Type | Name |
| -------------| -------------|
| int| slot|
| List\<String\>| pages|
| Optional\<String\>| title|

#### 0x0E - Entity Tag Query
| Type | Name |
| -------------| -------------|
| int| transaction id|
| int| entity id|

#### 0x0F - Interact Packet
| Type | Name |
| -------------| -------------|
| int| entity id|
| Action| action|
| boolean| using secondary action|

#### 0x10 - Jigsaw Generate Packet
| Type | Name |
| -------------| -------------|
| BlockPos| pos|
| int| levels|
| boolean| keep jigsaws|

#### 0x11 - Keep Alive Packet
| Type | Name |
| -------------| -------------|
| long| id|

#### 0x12 - Lock Difficulty Packet
| Type | Name |
| -------------| -------------|
| boolean| locked|

#### 0x13 - Pos
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

#### 0x14 - Pos Rot
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

#### 0x15 - Rot
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

#### 0x16 - Status Only
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

#### 0x17 - Move Vehicle Packet
| Type | Name |
| -------------| -------------|
| double| x|
| double| y|
| double| z|
| float| y rot|
| float| x rot|

#### 0x18 - Paddle Boat Packet
| Type | Name |
| -------------| -------------|
| boolean| left|
| boolean| right|

#### 0x19 - Pick Item Packet
| Type | Name |
| -------------| -------------|
| int| slot|

#### 0x1A - Place Recipe Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| ResourceLocation| recipe|
| boolean| shift down|

#### 0x1B - Player Abilities Packet
| Type | Name |
| -------------| -------------|
| boolean| is flying|

#### 0x1C - Player Action Packet
| Type | Name |
| -------------| -------------|
| BlockPos| pos|
| Direction| direction|
| Action| action|
| int| sequence|

#### 0x1D - Player Command Packet
| Type | Name |
| -------------| -------------|
| int| id|
| Action| action|
| int| data|

#### 0x1E - Player Input Packet
| Type | Name |
| -------------| -------------|
| float| xxa|
| float| zza|
| boolean| is jumping|
| boolean| is shift key down|

#### 0x1F - Pong Packet
| Type | Name |
| -------------| -------------|
| int| id|

#### 0x20 - Chat Session Update Packet
| Type | Name |
| -------------| -------------|
| Data| chat session|

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



